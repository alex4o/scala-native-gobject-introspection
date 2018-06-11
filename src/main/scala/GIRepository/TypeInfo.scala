package GIRepository

import scala.scalanative.native._

class TypeInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def arrayFixedSize(): CInt = GIRepository.type_info_get_array_fixed_size(this.__ref)

  def arrayLength(): CInt = GIRepository.type_info_get_array_length(this.__ref)

  def arrayType(): CInt = GIRepository.type_info_get_array_type(this.__ref)

  def interface = new BaseInfo(GIRepository.type_info_get_interface(__ref))

  def paramType(n: Int) = new TypeInfo(GIRepository.type_info_get_param_type(__ref, n))

  def tag = TypeTag( GIRepository.type_info_get_tag(this.__ref) )

  def isPointer: Boolean = GIRepository.type_info_is_pointer(this.__ref) == 1

  def isZeroTerminated: Boolean = GIRepository.type_info_is_zero_terminated(this.__ref) == 1
}

object TypeInfo {
  def apply(__ref: Ptr[Byte]): TypeInfo = new TypeInfo(__ref)
}

