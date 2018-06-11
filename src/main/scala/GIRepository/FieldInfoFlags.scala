package GIRepository

import scala.scalanative.native._


object FieldInfoFlags extends Enumeration /* bitfield */ { // GIFieldInfoFlags

	val Readable = Value(1) // GI_FIELD_IS_READABLE
	val Writable = Value(2) // GI_FIELD_IS_WRITABLE

}
