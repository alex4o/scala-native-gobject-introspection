package GIRepository 

import scala.scalanative.native._

class ArgInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def closure: CInt = GIRepository.arg_info_get_closure(this.__ref)
  def destroy: CInt = GIRepository.arg_info_get_destroy(this.__ref)
  def direction = Direction(GIRepository.arg_info_get_direction(this.__ref))
  def ownershipTransfer(): CInt = GIRepository.arg_info_get_ownership_transfer(this.__ref)
  def scope(): CInt = GIRepository.arg_info_get_scope(this.__ref)
  def _type() = TypeInfo( GIRepository.arg_info_get_type(this.__ref) )
  def isCallerAllocates: CInt = GIRepository.arg_info_is_caller_allocates(this.__ref)
  def isOptional: CInt = GIRepository.arg_info_is_optional(this.__ref)
  def isReturnValue: CInt = GIRepository.arg_info_is_return_value(this.__ref)
  def isSkip: CInt = GIRepository.arg_info_is_skip(this.__ref)
  def loadType(Type: BaseInfo): Unit = GIRepository.arg_info_load_type(this.__ref, Type.__ref)
  def mayBeNull: CInt = GIRepository.arg_info_may_be_null(this.__ref)
}

object ArgInfo { def apply(__ref: Ptr[Byte]): ArgInfo = new ArgInfo(__ref) }

