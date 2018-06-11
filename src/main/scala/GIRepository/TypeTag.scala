package GIRepository

import scala.scalanative.native._


object TypeTag extends Enumeration{ // GITypeTag

	val Void = Value(0, "Unit") // GI_TYPE_TAG_VOID
	val Boolean = Value(1, "CInt") // GI_TYPE_TAG_BOOLEAN
	val Int8 = Value(2, "CChar") // GI_TYPE_TAG_INT8
	val Uint8 = Value(3, "CUnsignedChar") // GI_TYPE_TAG_UINT8
	val Int16 = Value(4, "CShort") // GI_TYPE_TAG_INT16
	val Uint16 = Value(5, "CUnsignedShort") // GI_TYPE_TAG_UINT16
	val Int32 = Value(6, "CInt") // GI_TYPE_TAG_INT32
	val Uint32 = Value(7, "CUnsignedInt") // GI_TYPE_TAG_UINT32
	val Int64 = Value(8, "CLong") // GI_TYPE_TAG_INT64
	val Uint64 = Value(9, "CUnsignedLong") // GI_TYPE_TAG_UINT64
	val Float = Value(10, "CFloat") // GI_TYPE_TAG_FLOAT
	val Double = Value(11, "CDouble") // GI_TYPE_TAG_DOUBLE
	val Gtype = Value(12, "GType") // GI_TYPE_TAG_GTYPE
	val Utf8 = Value(13, "CString") // GI_TYPE_TAG_UTF8
	val Filename = Value(14, "File") // GI_TYPE_TAG_FILENAME
	val Array = Value(15, "Array") // GI_TYPE_TAG_ARRAY
	val Interface = Value(16, "Interface") // GI_TYPE_TAG_INTERFACE
	val Glist = Value(17, "GList") // GI_TYPE_TAG_GLIST
	val Gslist = Value(18, "GSList") // GI_TYPE_TAG_GSLIST
	val Ghash = Value(19, "GHash") // GI_TYPE_TAG_GHASH
	val Error = Value(20, "Error") // GI_TYPE_TAG_ERROR
	val Unichar = Value(21, "CString") // GI_TYPE_TAG_UNICHAR

	def _from(index: Int): TypeTag.Value = {
		this.from(index)
	}

}
