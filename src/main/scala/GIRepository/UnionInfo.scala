package GIRepository 

import scala.scalanative.native._

class UnionInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def findMethod(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.union_info_find_method(this.__ref, toCString(Name))
  }
  def alignment= GIRepository.union_info_get_alignment(this.__ref)
  def discriminator(N: Int): Ptr[Byte] = GIRepository.union_info_get_discriminator(this.__ref, N)
  def discriminatorOffset(): CInt = GIRepository.union_info_get_discriminator_offset(this.__ref)
  def discriminatorType(): Ptr[Byte] = GIRepository.union_info_get_discriminator_type(this.__ref)
  def field(N: Int): Ptr[Byte] = GIRepository.union_info_get_field(this.__ref, N)
  def method(N: Int): Ptr[Byte] = GIRepository.union_info_get_method(this.__ref, N)
  def nFields(): CInt = GIRepository.union_info_get_n_fields(this.__ref)
  def nMethods(): CInt = GIRepository.union_info_get_n_methods(this.__ref)
  def size = GIRepository.union_info_get_size(this.__ref)
  def isDiscriminated(): CInt = GIRepository.union_info_is_discriminated(this.__ref)
}

object UnionInfo { def apply(__ref: Ptr[Byte]): UnionInfo = new UnionInfo(__ref) }

