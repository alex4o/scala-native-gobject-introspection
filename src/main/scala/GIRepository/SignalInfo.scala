package GIRepository 

import scala.scalanative.native._

class SignalInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def classClosure(): Ptr[Byte] = GIRepository.signal_info_get_class_closure(this.__ref)
  def flags = GIRepository.signal_info_get_flags(this.__ref)
  def trueStopsEmit(): CInt = GIRepository.signal_info_true_stops_emit(this.__ref)
}

object SignalInfo { def apply(__ref: Ptr[Byte]): SignalInfo = new SignalInfo(__ref) }

