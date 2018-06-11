package GIRepository

import scala.scalanative.native._

class EnumInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def errorDomain(): CString = GIRepository.enum_info_get_error_domain(this.__ref)

  def method(N: Int): Ptr[Byte] = GIRepository.enum_info_get_method(this.__ref, N)

  def nMethods(): CInt = GIRepository.enum_info_get_n_methods(this.__ref)

  def nValues(): CInt = GIRepository.enum_info_get_n_values(this.__ref)

  def storageType(): CInt = GIRepository.enum_info_get_storage_type(this.__ref)

  def value(N: Int): Ptr[Byte] = GIRepository.enum_info_get_value(this.__ref, N)


  def values: List[ValueInfo] = {
    var vs: List[ValueInfo] = List()
    val count = this.nValues()
    for (index <- (0 until count)) {
      val v = ValueInfo(this.value(index))
      vs = vs :+ v
    }
    vs
  }

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

object EnumInfo {
  def apply(__ref: Ptr[Byte]): EnumInfo = new EnumInfo(__ref)
}

