package GIRepository 

import scala.scalanative.native._

class ValueInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) { def value(): CLong = GIRepository.value_info_get_value(this.__ref) }

object ValueInfo { def apply(__ref: Ptr[Byte]): ValueInfo = new ValueInfo(__ref) }

