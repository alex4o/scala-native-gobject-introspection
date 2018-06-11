package GIRepository 

import scala.scalanative.native._

class FunctionInfo(override val __ref: Ptr[Byte]) extends CallableInfo(__ref) {
  def flags = GIRepository.function_info_get_flags(this.__ref)
  def property(): Ptr[Byte] = GIRepository.function_info_get_property(this.__ref)
  def symbol: String = fromCString(GIRepository.function_info_get_symbol(this.__ref))
  def vfunc(): Ptr[Byte] = GIRepository.function_info_get_vfunc(this.__ref)
}

object FunctionInfo { def apply(__ref: Ptr[Byte]): FunctionInfo = new FunctionInfo(__ref) }

