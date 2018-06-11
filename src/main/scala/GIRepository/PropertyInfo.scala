package GIRepository 

import scala.scalanative.native._

class PropertyInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def flags = GIRepository.property_info_get_flags(this.__ref)
  def ownershipTransfer(): CInt = GIRepository.property_info_get_ownership_transfer(this.__ref)
  def _type = GIRepository.property_info_get_type(this.__ref)
}

object PropertyInfo { def apply(__ref: Ptr[Byte]): PropertyInfo = new PropertyInfo(__ref) }

