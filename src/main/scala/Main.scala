import GIRepository._
import GLib.{List => GList}
import GLib.GLib

import scala.meta._
import scala.scalanative.native._
import scala.collection.immutable.Seq
import java.io.{FileOutputStream, File => JFile}

import util._
import Main.{args, obj}

import scala.collection.mutable.ListBuffer


@extern
object libc {
  def malloc(size: CSize): Ptr[Byte] = extern
}

object iop {
  def genFunction(function: FunctionInfo): Defn.Def = {
    var name = function.name
    val symbol = function.symbol

    if ((function.flags & FunctionInfoFlags.Is_constructor.id) > 0) {
      name = name.replace("new", "create")
    }

    var args: List[Term.Param] = function.arguments.map(genArgument)

    val returnType = new TypeInfo(function.returnType)
    var typeName = scalaInteropType(returnType)

    FunctionInfoFlags.test(function.flags).foreach({
      case FunctionInfoFlags.Is_method => args = List(param"self: Ptr[Byte]") ++ args
      case _ =>
    })

    q"""..${List(mod"@name($symbol)")} def ${name.asTermName}(..$args): ${typeName} = extern"""
  }

  def genArgument(arg: ArgInfo): Term.Param = {
    val typeName = scalaInteropType(arg)
    param" ${arg.name.asName}: ${typeName}"
  }
}

object Main extends App {


  def test(f: Int => Int): Int = {
    f(12) + 12
  }
  println(test(_ + 1))



//  def getList(obj: Ptr[Byte], size: Int, get: (Ptr[Byte], CInt) => Ptr[Byte]): List[Ptr[Byte]] = {
//
//    var list: List[Ptr[Byte]] = List()
//
//    (0 until size).foreach(index => {
//      list = list :+ get(obj, index)
//    })
//
//    list
//  }


  println("Hello, World!")
  val namespace = c"GIRepository"
  val sNS = fromCString(namespace)
//  val namespace = c"Gtk"
  val repository = Repository.get_default()
  Repository.require(repository, namespace, c"2.0", 0);

  var path = Repository.get_typelib_path(repository, namespace)

  println(fromCString(path))

  val info_count = Repository.get_n_infos(repository, namespace)
  var library = fromCString(Repository.get_shared_library(repository, namespace)).split("so")(0)

  println(library)


  var global: ListBuffer[Defn] = ListBuffer()

  for (i <- 0 to info_count) {
    val info = new BaseInfo(Repository.get_info(repository, namespace, i))
    val infoType = info.typeInfo


    infoType match {
      case InfoType.Object => {
        val objectInfo = ObjectInfo(info.__ref)

        val name = info.name

        //        println(s"object $name")

        var methods: List[Defn] = objectInfo.methods.map(iop.genFunction)

        val imports = List(q"import scala.scalanative.native._")
        var obj = q"""object ${name.asTermName} {  ..$methods }"""
        obj = transformers.addAnotation(obj, List(mod"@extern", mod"@link($library)"))

        saveObjectSource(sNS, name, q"..$imports; $obj");

        println(obj)

      }
      case InfoType.Function => {
        val functionInfo = FunctionInfo(info.__ref)
        global += iop.genFunction(functionInfo)
      }
      case InfoType.Enum => {
        val name = info.name
        val enumInfo = EnumInfo(info.__ref)

        var methods: List[Defn] = enumInfo.methods.map(iop.genFunction)

        val value_count = GIRepository.enum_info_get_n_values(info.__ref)
        for (valueInfo <- enumInfo.values) {
          val value = valueInfo.value.toInt
          methods = methods ++ List(q"""val ${Pat.Var(camelify(valueInfo.name).capitalize.asTermName())} = Value(${value}) """)
        }
          //          println(s"${args.map(t => s"${t._1}: ${t._2}").mkString(", ")}): Unit = ???")

        val obj = q" object ${name.asTermName} extends Enumeration {  ..$methods } "

        saveObjectSource(sNS, name, q"import scala._; $obj")

        println(obj)


      }
      case InfoType.Struct => {
        val name = info.name
        var methods: List[Defn] = List()


        val method_count = GIRepository.struct_info_get_n_methods(info.__ref)
        for (method_index <- (0 until method_count)) {
          val method = GIRepository.struct_info_get_method(info.__ref, method_index)
          var name = fromCString(BaseInfo.ext.get_name(method))
          val symbol = fromCString(GIRepository.function_info_get_symbol(method))

          if (GIRepository.function_info_get_flags(method).&(FunctionInfoFlags.Is_constructor.id) > 0) {
            name = name.replace("new", "create")
          }

          //          print(s"def $name(")

          val arg_count = GIRepository.callable_info_get_n_args(method)
          var args: List[Term.Param] = List()
          for (arg_index <- (0 until arg_count)) {
            val arg = ArgInfo( GIRepository.callable_info_get_arg(method, arg_index) )


            val typeName = scalaInteropType(arg)

            args = args ++ List(param"${arg.name.asName}: ${typeName}")
          }

          val returnType = new TypeInfo(GIRepository.callable_info_get_return_type(method))
          var typeName = scalaInteropType(returnType)

          val flags = GIRepository.function_info_get_flags(method)

          methods = methods ++ List(q"""..${List(mod"@name($symbol)")} def ${name.asTermName}(..$args): ${typeName} = extern""")

        }


        // ----------


        val field_count = GIRepository.struct_info_get_n_fields(info.__ref)
        for (field_index <- 0 until field_count) {
          val fieldInfo = new BaseInfo( GIRepository.struct_info_get_field(info.__ref, field_index) )
          val value =  new TypeInfo(GIRepository.field_info_get_type(fieldInfo.__ref))
          var typeName = scalaInteropType(value)
          fieldInfo.attributes

          GIRepository.field_info_get_flags(fieldInfo.__ref)

          methods = methods ++ List(q"""..${List(mod"@field")} def ${fieldInfo.name.asTermName}: ${typeName} = ???""")

        }

        val imports = List(q"import annotations._")
        val mods = List(mod"@extern", mod"@link($library)")
        val obj = q"..$mods object ${name.asTermName}  {  ..$methods }"

        saveObjectSource(sNS, name, q"..$imports; $obj");


//        println(transformers.removeBody(obj))


      }
      case _ => {

      }
    }
  }

  // only for use with GIRepository

/*
  def c_to_s_params(param: Term.Param) = {
    println(param)

    param match
    {
      case param"$pmod $pn: $pt" => {
        pmod match {
          case mod"@obj($tn)" => {
            param"$pn: ${tn.toString.replaceAll("^\"|\"$", "").asTypeName}"
          }
          case mod"@enum($tn)" => {
            param"$pn: ${Type.Name(tn.toString.replaceAll("^\"|\"$", ""))}"
          }
          case mod"@unichar" =>
            param"$pn: String"
          case mod"@utf8" =>
            param"$pn: String"
        }
      }
      case param"$pn: $pt" => {
        val s_type = pt.get.toString().tail

        param"$pn: ${s_type.asTypeName}"
      }
      case _ => {
        param"unk: Any"
      }
    }
  }


  def methodTrans(method: Defn): Defn = method match {
    case q"..$mods def $methodName( ..$params ): $rett = $body" => {
      val newParams = params.map( c_to_s_params(_))
      var zone = false
      var names = params
        .map({ case param"@$mn $name: $t" => (name.value, t.get) })
        .map({ case (name :String, _type: Type.Name) =>
          {
            println(_type)
            _type match {
              case Type.Name("CString") => {
                zone = true
                q"toCString(${Term.Name(name)})"
              }
              case _ => Term.Name(name)
            }
          }
        })
      val newName = Term.Name(camelifyMethod(methodName.value.split("_info")(1).replace("get_", "")))
      if(names.length > 0) {
        names = names.tail
      }

      if(zone) {
          return q"def $newName( ..$newParams ): $rett = Zone { implicit z => ${sNS.asTermName}.$methodName(this.__ref, ..${names}) }"
      }
      q"def $newName( ..${newParams.tail} ): $rett = ${Term.Name(sNS)}.$methodName(this.__ref, ..${names})"
    }
  }

//  val betterGlobals = global.map {

//  }
  val betterGlobals = global.filter {
    case q"..$_ def $methodName( ...$_ ): $_ = $_" => methodName.value.contains("_info")
  } .groupBy {
    case q"..$_ def $methodName( ...$_ ): $_ = $_" => {
      methodName.value.split("_info") match {
        case Array(name, _) => name
        case _ => "global"
      }
    }
  }


  val classes = betterGlobals.flatMap {
    case ("global", _) => None
    case (tName, methods) => {
      val className = camelify(s"${tName}_Info").asTypeName()
      Some(q"class $className(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) { ..${methods.map(methodTrans).toList} }")

    }

  }


  classes.foreach((klass: Defn.Class) => {

    saveObjectSource(sNS, klass.name.value, q" ${klass}; object ${klass.name.value.asTermName()} { def apply(__ref: Ptr[Byte]): ${klass.name} = new ${klass.name}(__ref) }")
  })
*/
  val imports = List( q"import scala.scalanative.native._")

  val mods = List(mod"@extern", mod"@link($library)")
  var obj = q"""..$mods object ${sNS.asTermName()}  {  ..${global.toList} }"""

//  println(transformers.classess(obj))

  saveObjectSource(sNS, sNS, q" ..$imports; $obj")

  //    println(transformers.removeBody(obj))
  println(transformers.removeBody(obj))


  val list = Repository.get_loaded_namespaces(repository)
  //  SList.foreach(list, (data: Ptr[Byte]) => {
  //
  //    println(fromCString(data.cast[CString]))
  //
  //  }, 0.cast[Ptr[Byte]])

}

object asa {
  object o { def a(): Int = 12 }
  def as = o.a() + 1
}
