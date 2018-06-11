package GIRepository

import scala.scalanative.native._


object VFuncInfoFlags extends Enumeration /* bitfield */ { // GIVFuncInfoFlags

	val Must_chain_up = Value(1) // GI_VFUNC_MUST_CHAIN_UP
	val Must_override = Value(2) // GI_VFUNC_MUST_OVERRIDE
	val Must_not_override = Value(4) // GI_VFUNC_MUST_NOT_OVERRIDE
	val Throws = Value(8) // GI_VFUNC_THROWS

}
