package GIRepository 

import scala.meta.Term
import scala.scalanative.native._

class CallableInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def canThrowGerror(): CInt = GIRepository.callable_info_can_throw_gerror(this.__ref)
  def arg(N: Int): Ptr[Byte] = GIRepository.callable_info_get_arg(this.__ref, N)
  def callerOwns(): CInt = GIRepository.callable_info_get_caller_owns(this.__ref)
  def instanceOwnershipTransfer(): CInt = GIRepository.callable_info_get_instance_ownership_transfer(this.__ref)
  def nArgs(): CInt = GIRepository.callable_info_get_n_args(this.__ref)
  def returnAttribute(Info: BaseInfo, Name: String): CString = Zone { implicit z => 
    GIRepository.callable_info_get_return_attribute(this.__ref, toCString(Name))
  }
  def returnType(): Ptr[Byte] = GIRepository.callable_info_get_return_type(this.__ref)
//  def invoke(Function: Ptr[Byte], In_args: Argument, N_in_args: Int, Out_args: Argument, N_out_args: Int, Return_value: Argument, Is_method: Int, Throws: Int): CInt = GIRepository.callable_info_invoke(this.__ref, Function, In_args, N_in_args, Out_args, N_out_args, Return_value, Is_method, Throws)
  def isMethod(): CInt = GIRepository.callable_info_is_method(this.__ref)
//  def iterateReturnAttributes(Info: BaseInfo, Iterator: Ptr[Byte], Name: String, Value: String): CInt = Zone { implicit z =>
//    GIRepository.callable_info_iterate_return_attributes(this.__ref, Iterator, toCString(Name), toCString(Value))
//  }
  def loadArg(N: Int, Arg: BaseInfo): Unit = GIRepository.callable_info_load_arg(this.__ref, N, Arg.__ref)
  def loadReturnType(Type: BaseInfo) = {
    val t = Type.__ref
    GIRepository.callable_info_load_return_type(this.__ref, t)
  }
  def mayReturnNull(): CInt = GIRepository.callable_info_may_return_null(this.__ref)
  def skipReturn(): CInt = GIRepository.callable_info_skip_return(this.__ref)

  def arguments: List[ArgInfo] = {
    var args: List[ArgInfo] = List()
    val arg_count = this.nArgs()
    for (arg_index <- (0 until arg_count)) {
      val arg = ArgInfo(this.arg(arg_index))
      args = args :+ arg
    }
    args
  }
}

object CallableInfo { def apply(__ref: Ptr[Byte]): CallableInfo = new CallableInfo(__ref) }

