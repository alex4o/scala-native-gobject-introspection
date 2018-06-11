package GIRepository 

import scala.scalanative.native._

class StructInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def findField(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.struct_info_find_field(this.__ref, toCString(Name))
  }
  def findMethod(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.struct_info_find_method(this.__ref, toCString(Name))
  }
  def alignment = GIRepository.struct_info_get_alignment(this.__ref)
  def field(N: Int): Ptr[Byte] = GIRepository.struct_info_get_field(this.__ref, N)
  def method(N: Int): Ptr[Byte] = GIRepository.struct_info_get_method(this.__ref, N)
  def nFields(): CInt = GIRepository.struct_info_get_n_fields(this.__ref)
  def nMethods(): CInt = GIRepository.struct_info_get_n_methods(this.__ref)
  def size  = GIRepository.struct_info_get_size(this.__ref)
  def isForeign(): CInt = GIRepository.struct_info_is_foreign(this.__ref)
  def isGtypeStruct(): CInt = GIRepository.struct_info_is_gtype_struct(this.__ref)

  def methods: List[FunctionInfo] = {
    var methods: List[FunctionInfo] = List()
    val count = this.nMethods()
    for (index <- (0 until count)) {
      val method = FunctionInfo(this.method(index))
      methods = methods :+ method
    }
    methods
  }
}

object StructInfo { def apply(__ref: Ptr[Byte]): StructInfo = new StructInfo(__ref) }

