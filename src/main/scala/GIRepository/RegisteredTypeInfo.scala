package GIRepository 

import scala.scalanative.native._

class RegisteredTypeInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def gType = GIRepository.registered_type_info_get_g_type(this.__ref)
  def typeInit(): CString = GIRepository.registered_type_info_get_type_init(this.__ref)
  def typeName(): CString = GIRepository.registered_type_info_get_type_name(this.__ref)
}

object RegisteredTypeInfo { def apply(__ref: Ptr[Byte]): RegisteredTypeInfo = new RegisteredTypeInfo(__ref) }

