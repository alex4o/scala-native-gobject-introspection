package GIRepository

import scala.scalanative.native._


object RepositoryError extends Enumeration{ // GIRepositoryError

	val Typelib_not_found = Value(0) // G_IREPOSITORY_ERROR_TYPELIB_NOT_FOUND
	val Namespace_mismatch = Value(1) // G_IREPOSITORY_ERROR_NAMESPACE_MISMATCH
	val Namespace_version_conflict = Value(2) // G_IREPOSITORY_ERROR_NAMESPACE_VERSION_CONFLICT
	val Library_not_found = Value(3) // G_IREPOSITORY_ERROR_LIBRARY_NOT_FOUND

}
