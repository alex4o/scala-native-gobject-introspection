import scala.meta._

object transformers {
  def addAnotation[T <: Tree](tree: T, anotations: List[Mod]): T = {
    tree.transform {
      case q"..$mods object $name { ..$body }" => q"..${mods ++ anotations} object $name { ..$body }"
//      case q"..$mods def $ename[..$tparams](...$paramss): = $body  $tpe" => q"..${anotations ++ mods.asInstanceOf[List[Mod]]} def $ename[..$tparams](...$paramss): $tpe = $body"
    }.asInstanceOf[T]
  }


  def removeBody[T <: Tree](tree: T): T = {
    tree.transform {
      case q"..$mods object $name { ..$body }" => q"..${mods} object $name"
      case q"..$mods def $ename[..$tparams](...$paramss): $tpe = $body" => q"..$mods def $ename[..$tparams](...$paramss): ${tpe.get}"
      case q"..$mods def $ename[..$tparams](...$paramss) = $body" => q"..$mods def $ename[..$tparams](...$paramss)"
    }.asInstanceOf[T]
  }

  def classess(tree: Tree): Tree = {
    tree.transform {
      case q"..$mods object $name { ..$body }" => {

        val grouped = body.groupBy({
          case q"..$_ def $_[..$_](@obj($name) $_: $_, ..$paramss): $_ = $_" => {
            name.toString()
          }
          case _ => "global"
        })
        println(grouped.keys)
        q"val a = 12"
      }
    }
  }
}
