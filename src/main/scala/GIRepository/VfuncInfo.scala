package GIRepository 

import scala.scalanative.native._

class VfuncInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def flags = GIRepository.vfunc_info_get_flags(this.__ref)
  def invoker(): Ptr[Byte] = GIRepository.vfunc_info_get_invoker(this.__ref)
  def offset(): CInt = GIRepository.vfunc_info_get_offset(this.__ref)
  def signal(): Ptr[Byte] = GIRepository.vfunc_info_get_signal(this.__ref)
}

object VfuncInfo { def apply(__ref: Ptr[Byte]): VfuncInfo = new VfuncInfo(__ref) }

