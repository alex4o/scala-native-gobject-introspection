package GIRepository

import scala.scalanative.native._


object ArrayType extends Enumeration{ // GIArrayType

	val C = Value(0) // GI_ARRAY_TYPE_C
	val Array = Value(1) // GI_ARRAY_TYPE_ARRAY
	val Ptr_array = Value(2) // GI_ARRAY_TYPE_PTR_ARRAY
	val Byte_array = Value(3) // GI_ARRAY_TYPE_BYTE_ARRAY

	def from_(index: Int): ArrayType.Value = {
		this.from(index)
	}

}
