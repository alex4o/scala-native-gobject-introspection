package GIRepository

import scala.scalanative.native._


import scala.scalanative.native._

class BaseInfo (val __ref: Ptr[Byte]) {
	import BaseInfo.ext
	def attribute(name: String): String = Zone { implicit z =>
		val c_str = toCString(name)
		fromCString(ext.get_attribute(__ref, c_str))
	}

	def container() = ext.get_container(__ref) // ??? What object
	def name = fromCString(ext.get_name(__ref))
	def namepace = fromCString(ext.get_namespace(__ref))
	def typeInfo = InfoType(ext.get_type(__ref))
	def isDeprecated = ext.is_deprecated(__ref) == 1

	override def equals(o: scala.Any): Boolean = o match {
		case b: BaseInfo => ext.equal(__ref, b.__ref) == 1
		case _ => false
	}

	def attributes = {
		val cname = stackalloc[CString]
		val cvalue = stackalloc[CString]
		val iter = stackalloc[Ptr[CStruct4[Ptr[Unit], Ptr[Unit], Ptr[Unit], Ptr[Unit]]]]

		while(ext.iterate_attributes(__ref, iter.cast[Ptr[Byte]], cname, cvalue) == 1){
			val name = fromCString(!cname)
			val value = fromCString(!cvalue)

			println(s"$name: $value")
		}
	}

}
object BaseInfo {
	def fromPtr(__ref: Ptr[Byte]): BaseInfo = new BaseInfo(__ref)

	@extern
	@link("girepository-1.0")
	object ext {

		@name("g_base_info_equal")
		def equal(BaseInfo: Ptr[Byte], Info2: Ptr[Byte]): CInt = extern

		@name("g_base_info_get_attribute")
		def get_attribute(BaseInfo: Ptr[Byte], Name: CString): CString = extern

		@name("g_base_info_get_container")
		def get_container(BaseInfo: Ptr[Byte]): Ptr[Byte] = extern

		@name("g_base_info_get_name")
		def get_name(BaseInfo: Ptr[Byte]): CString = extern

		@name("g_base_info_get_namespace")
		def get_namespace(BaseInfo: Ptr[Byte]): CString = extern

		@name("g_base_info_get_type")
		def get_type(BaseInfo: Ptr[Byte]): CInt /* GIInfoType */ = extern

		@name("g_base_info_get_typelib")
		def get_typelib(BaseInfo: Ptr[Byte]): Ptr[Byte] = extern

		@name("g_base_info_is_deprecated")
		def is_deprecated(BaseInfo: Ptr[Byte]): CInt = extern

		@name("g_base_info_iterate_attributes")
		def iterate_attributes(BaseInfo: Ptr[Byte], Iterator: Ptr[Byte], Name: Ptr[CString], Value: Ptr[CString]): CInt = extern

		@name("g_base_info_ref")
		def ref(BaseInfo: Ptr[Byte]): Ptr[Byte] = extern

		@name("g_base_info_unref")
		def unref(BaseInfo: Ptr[Byte]): Unit = extern

	}
}