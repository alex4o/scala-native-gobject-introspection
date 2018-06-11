package GIRepository 

import scala.scalanative.native._

class ConstantInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) { def _type(): Ptr[Byte] = GIRepository.constant_info_get_type(this.__ref) }

object ConstantInfo { def apply(__ref: Ptr[Byte]): ConstantInfo = new ConstantInfo(__ref) }

