package GIRepository

import scala.scalanative.native._


object nvokeError extends Enumeration{ // GInvokeError

	val Failed = Value(0) // G_INVOKE_ERROR_FAILED
	val Symbol_not_found = Value(1) // G_INVOKE_ERROR_SYMBOL_NOT_FOUND
	val Argument_mismatch = Value(2) // G_INVOKE_ERROR_ARGUMENT_MISMATCH

}
