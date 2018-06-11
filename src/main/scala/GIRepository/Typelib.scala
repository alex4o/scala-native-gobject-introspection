package GIRepository

import scala.scalanative.native._

@extern
@link("girepository-1.0")
object Typelib {

	@name("g_typelib_free")
	def free(Typelib: Ptr[Byte]): Unit = extern

	@name("g_typelib_get_namespace")
	def get_namespace(Typelib: Ptr[Byte]): CString = extern

	@name("g_typelib_symbol")
	def symbol(Typelib: Ptr[Byte], Symbolname: CString, Symbol: Ptr[Ptr[Byte]]): CInt = extern

}