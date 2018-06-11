package GIRepository

import scala.scalanative.native._


object ScopeType extends Enumeration{ // GIScopeType

	val Invalid = Value(0) // GI_SCOPE_TYPE_INVALID
	val Call = Value(1) // GI_SCOPE_TYPE_CALL
	val Async = Value(2) // GI_SCOPE_TYPE_ASYNC
	val Notified = Value(3) // GI_SCOPE_TYPE_NOTIFIED

}
