package GIRepository

import scala.scalanative.native._


object Transfer extends Enumeration{ // GITransfer

	val Nothing = Value(0) // GI_TRANSFER_NOTHING
	val Container = Value(1) // GI_TRANSFER_CONTAINER
	val Everything = Value(2) // GI_TRANSFER_EVERYTHING

}
