package GIRepository

import scala.scalanative.native._

@extern
@link("girepository-1.0")
object Repository {

	@name("g_irepository_enumerate_versions")
	def enumerate_versions(Repository: Ptr[Byte], Namespace: CString): Ptr[Byte] = extern

	@name("g_irepository_find_by_error_domain")
	def find_by_error_domain(Repository: Ptr[Byte], Domain: CInt /* GQuark */): Ptr[Byte] = extern

	@name("g_irepository_find_by_gtype")
	def find_by_gtype(Repository: Ptr[Byte], Gtype: CInt /* GType */): Ptr[Byte] = extern

	@name("g_irepository_find_by_name")
	def find_by_name(Repository: Ptr[Byte], Namespace: CString, Name: CString): Ptr[Byte] = extern

	@name("g_irepository_get_c_prefix")
	def get_c_prefix(Repository: Ptr[Byte], Namespace: CString): CString = extern

	@name("g_irepository_get_dependencies")
	def get_dependencies(Repository: Ptr[Byte], Namespace: CString): Unit = extern

	@name("g_irepository_get_immediate_dependencies")
	def get_immediate_dependencies(Repository: Ptr[Byte], Namespace: CString): Unit = extern

	@name("g_irepository_get_info")
	def get_info(Repository: Ptr[Byte], Namespace: CString, Index: CInt): Ptr[Byte] = extern

	@name("g_irepository_get_loaded_namespaces")
	def get_loaded_namespaces(Repository: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_irepository_get_n_infos")
	def get_n_infos(Repository: Ptr[Byte], Namespace: CString): CInt = extern

	@name("g_irepository_get_shared_library")
	def get_shared_library(Repository: Ptr[Byte], Namespace: CString): CString = extern

	@name("g_irepository_get_typelib_path")
	def get_typelib_path(Repository: Ptr[Byte], Namespace: CString): CString = extern

	@name("g_irepository_get_version")
	def get_version(Repository: Ptr[Byte], Namespace: CString): CString = extern

	@name("g_irepository_is_registered")
	def is_registered(Repository: Ptr[Byte], Namespace: CString, Version: CString): CInt = extern

	@name("g_irepository_load_typelib")
	def load_typelib(Repository: Ptr[Byte], Typelib: Ptr[Byte], Flags: CInt /* GIRepositoryLoadFlags */): CString = extern

	@name("g_irepository_require")
	def require(Repository: Ptr[Byte], Namespace: CString, Version: CString, Flags: CInt /* GIRepositoryLoadFlags */): Ptr[Byte] = extern

	@name("g_irepository_require_private")
	def require_private(Repository: Ptr[Byte], Typelibdir: CString, Namespace: CString, Version: CString, Flags: CInt /* GIRepositoryLoadFlags */): Ptr[Byte] = extern


// Static functions
	@name("g_irepository_dump")
	def dump(Arg: CString): CInt = extern

	@name("g_irepository_error_quark")
	def error_quark(): CInt /* GQuark */ = extern

	@name("g_irepository_get_default")
	def get_default(): Ptr[Byte] = extern

	@name("g_irepository_get_option_group")
	def get_option_group(): Ptr[Byte] = extern

	@name("g_irepository_get_search_path")
	def get_search_path(): Ptr[Byte] = extern

	@name("g_irepository_prepend_library_path")
	def prepend_library_path(Directory: CString): Unit = extern

	@name("g_irepository_prepend_search_path")
	def prepend_search_path(Directory: CString): Unit = extern


// Constructors
}