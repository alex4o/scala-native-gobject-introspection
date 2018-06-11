package GIRepository

import scala.scalanative.native._


object InfoType extends Enumeration{ // GIInfoType

	val Invalid = Value(0) // GI_INFO_TYPE_INVALID
	val Function = Value(1) // GI_INFO_TYPE_FUNCTION
	val Callback = Value(2) // GI_INFO_TYPE_CALLBACK
	val Struct = Value(3) // GI_INFO_TYPE_STRUCT
	val Boxed = Value(4) // GI_INFO_TYPE_BOXED
	val Enum = Value(5) // GI_INFO_TYPE_ENUM
	val Flags = Value(6) // GI_INFO_TYPE_FLAGS
	val Object = Value(7) // GI_INFO_TYPE_OBJECT
	val Interface = Value(8) // GI_INFO_TYPE_INTERFACE
	val Constant = Value(9) // GI_INFO_TYPE_CONSTANT
	val Invalid_0 = Value(10) // GI_INFO_TYPE_INVALID_0
	val Union = Value(11) // GI_INFO_TYPE_UNION
	val value = Value(12) // GI_INFO_TYPE_VALUE
	val Signal = Value(13) // GI_INFO_TYPE_SIGNAL
	val Vfunc = Value(14) // GI_INFO_TYPE_VFUNC
	val Property = Value(15) // GI_INFO_TYPE_PROPERTY
	val Field = Value(16) // GI_INFO_TYPE_FIELD
	val Arg = Value(17) // GI_INFO_TYPE_ARG
	val Type = Value(18) // GI_INFO_TYPE_TYPE
	val Unresolved = Value(19) // GI_INFO_TYPE_UNRESOLVED

}
