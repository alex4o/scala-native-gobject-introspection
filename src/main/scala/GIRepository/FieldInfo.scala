package GIRepository 

import scala.scalanative.native._

class FieldInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def flags = GIRepository.field_info_get_flags(this.__ref)
  def offset(): CInt = GIRepository.field_info_get_offset(this.__ref)
  def size(): CInt = GIRepository.field_info_get_size(this.__ref)
  def _type(): Ptr[Byte] = GIRepository.field_info_get_type(this.__ref)
}

object FieldInfo { def apply(__ref: Ptr[Byte]): FieldInfo = new FieldInfo(__ref) }

