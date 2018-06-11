package anotations

case class obj(name: String) extends scala.annotation.StaticAnnotation
case class enum(name: String) extends scala.annotation.StaticAnnotation
case class unichar() extends scala.annotation.StaticAnnotation
case class utf8() extends scala.annotation.StaticAnnotation

case class ctor() extends scala.annotation.StaticAnnotation
case class get() extends scala.annotation.StaticAnnotation
case class set() extends scala.annotation.StaticAnnotation
