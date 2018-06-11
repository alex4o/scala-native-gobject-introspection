package GIRepository

import scala.scalanative.native._


object Direction extends Enumeration{ // GIDirection

	val In = Value(0) // GI_DIRECTION_IN
	val Out = Value(1) // GI_DIRECTION_OUT
	val Inout = Value(2) // GI_DIRECTION_INOUT

}
