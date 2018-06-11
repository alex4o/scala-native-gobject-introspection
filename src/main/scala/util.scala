import java.io.{File, _}

import GIRepository._

import scala.meta._

object util {
  /**
    * Turn a string of format "FooBar" into snake case "foo_bar"
    *
    * Note: snakify is not reversible, ie. in general the following will _not_ be true:
    *
    * s == camelify(snakify(s))
    *
    * @return the underscored string
    */
  def snakify(name : String) = name.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z\\d])([A-Z])", "$1_$2").toLowerCase


  /**
    * Turns a string of format "foo_bar" into camel case "FooBar"
    *
    * Functional code courtesy of Jamie Webb (j@jmawebb.cjb.net) 2006/11/28
    * @param name the String to CamelCase
    *
    * @return the CamelCased string
    */
  def camelify(name : String): String = {
    def loop(x : List[Char]): List[Char] = (x: @unchecked) match {
      case '_' :: '_' :: rest => loop('_' :: rest)
      case '_' :: c :: rest => Character.toUpperCase(c) :: loop(rest)
      case '_' :: Nil => Nil
      case c :: rest => c :: loop(rest)
      case Nil => Nil
    }
    if (name == null)
      ""
    else
      loop('_' :: name.toList).mkString
  }

  /**
    * Turn a string of format "foo_bar" into camel case with the first letter in lower case: "fooBar"
    * This function is especially used to camelCase method names.
    *
    * @param name the String to CamelCase
    *
    * @return the CamelCased string
    */
  def camelifyMethod(name: String): String = {
    val tmp: String = camelify(name)
    if (tmp.length == 0)
      ""
    else
      tmp.substring(0,1).toLowerCase + tmp.substring(1)
  }

  implicit class StringImprovements(val s: String) {
    implicit def asTerm(): Term = s.parse[Term].get
    implicit def asPat(): Pat = s.parse[Pat].get

    implicit def asTermName(): Term.Name = Term.Name(s)

    implicit def asTypeName(): Type.Name = Type.Name(s)

    implicit def asName(): scala.meta.Name = scala.meta.Name(s)
  }


    def scalaInteropType(arg: ArgInfo): Type.Name = {
      val info = arg._type
      var res = scalaInteropType(info).value
      arg.direction match {
        case Direction.In =>
        case Direction.Out => res = s"Ptr[$res]"
        case Direction.Inout => res = s"Ptr[$res]"
      }
      res.asTypeName
    }

    def scalaInteropType(info: TypeInfo): Type.Name = {


    var res = info.tag match {

      case TypeTag.Array => {
        val fixedSize = info.arrayFixedSize
        val length = info.arrayLength
        val arrayType = info.arrayType

        val typeName = scalaInteropType(info.paramType(0))
        s"Array[${typeName}]"

      }
      case TypeTag.Gtype => {
        "CInt"
      }
      case TypeTag.Filename => {
        "CString"
      }
      case TypeTag.Interface => {
        info.interface.typeInfo match {
          case InfoType.Enum => "CInt"
          case InfoType.Flags => "CInt"
          case _ => {
            s"Ptr[Byte]"
          }
        }

      }
      case TypeTag.Unichar => "CString"
      case TypeTag.Utf8 => "CString"
      case TypeTag.Glist => s"Ptr[Byte]"
      case TypeTag.Gslist => s"Ptr[Byte]"
      case TypeTag.Void => {
        if (info.isPointer) {
          s"Ptr[Byte]"
        } else {
          s"Unit"
        }
      }
      case tag => {
        if (info.isPointer) {
          s"Ptr[${tag.toString}]"
        } else {
          tag.toString
        }
      }
    }

    res.asTypeName
  }

  def saveObjectSource(namespace: String, name: String, obj: Tree): Unit = {
//    println(obj)
    val dir = new File(s"./$namespace")
    dir.mkdirs()

    val f = new File(s"./$namespace/$name.scala")
    f.createNewFile()
    val ws = new FileWriter(f)
    val ss = new BufferedWriter(ws)

    ss.append(s"package $namespace \n\n")
    obj.children.foreach(child => ss.append(child.syntax + "\n\n"))
    ss.flush()

  }

}
