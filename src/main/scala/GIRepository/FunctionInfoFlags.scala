package GIRepository

import scala.scalanative.native._


object FunctionInfoFlags extends Enumeration /* bitfield */ { // GIFunctionInfoFlags

	val Is_method = Value(1) // GI_FUNCTION_IS_METHOD
	val Is_constructor = Value(2) // GI_FUNCTION_IS_CONSTRUCTOR
	val Is_getter = Value(4) // GI_FUNCTION_IS_GETTER
	val Is_setter = Value(8) // GI_FUNCTION_IS_SETTER
	val Wraps_vfunc = Value(16) // GI_FUNCTION_WRAPS_VFUNC
	val Throws = Value(32) // GI_FUNCTION_THROWS


	def test(bitfield: Int): List[FunctionInfoFlags.Value] = {
		this.values.flatMap(value => {
					if((bitfield & value.id) == value.id){
						Some(value)
					}else{
						None
					}
				})(collection.breakOut)
	}

}
