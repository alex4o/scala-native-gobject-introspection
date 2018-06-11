package GIRepository

import scala.scalanative.native._

class ObjectInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def findMethod(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z =>
    GIRepository.object_info_find_method(this.__ref, toCString(Name))
  }
  def findMethodUsingInterfaces(Info: BaseInfo, Name: String, Implementor: BaseInfo): Ptr[Byte] = Zone { implicit z =>
    var impl = stackalloc[Ptr[Byte]]
    !impl = Implementor.__ref
    GIRepository.object_info_find_method_using_interfaces(this.__ref, toCString(Name), impl)
  }
  def findSignal(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z =>
    GIRepository.object_info_find_signal(this.__ref, toCString(Name))
  }
  def findVfunc(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z =>
    GIRepository.object_info_find_vfunc(this.__ref, toCString(Name))
  }
  def findVfuncUsingInterfaces(Info: BaseInfo, Name: String, Implementor: BaseInfo): Ptr[Byte] = Zone { implicit z =>
    var impl = stackalloc[Ptr[Byte]]
    !impl = Implementor.__ref
    GIRepository.object_info_find_vfunc_using_interfaces(this.__ref, toCString(Name), impl)
  }
  def `abstract`(): CInt = GIRepository.object_info_get_abstract(this.__ref)
  def classStruct(): Ptr[Byte] = GIRepository.object_info_get_class_struct(this.__ref)
  def constant(N: Int): Ptr[Byte] = GIRepository.object_info_get_constant(this.__ref, N)
  def field(N: Int): Ptr[Byte] = GIRepository.object_info_get_field(this.__ref, N)
  def fundamental(): CInt = GIRepository.object_info_get_fundamental(this.__ref)
  def valueFunction(): CString = GIRepository.object_info_get_get_value_function(this.__ref)
  def interface(N: Int): Ptr[Byte] = GIRepository.object_info_get_interface(this.__ref, N)
  def method(N: Int): Ptr[Byte] = GIRepository.object_info_get_method(this.__ref, N)
  def nConstants(): CInt = GIRepository.object_info_get_n_constants(this.__ref)
  def nFields(): CInt = GIRepository.object_info_get_n_fields(this.__ref)
  def nInterfaces(): CInt = GIRepository.object_info_get_n_interfaces(this.__ref)
  def nMethods(): CInt = GIRepository.object_info_get_n_methods(this.__ref)
  def nProperties(): CInt = GIRepository.object_info_get_n_properties(this.__ref)
  def nSignals(): CInt = GIRepository.object_info_get_n_signals(this.__ref)
  def nVfuncs(): CInt = GIRepository.object_info_get_n_vfuncs(this.__ref)
  def parent(): Ptr[Byte] = GIRepository.object_info_get_parent(this.__ref)
  def property(N: Int): Ptr[Byte] = GIRepository.object_info_get_property(this.__ref, N)
  def refFunction(): CString = GIRepository.object_info_get_ref_function(this.__ref)
  def setValueFunction(): CString = GIRepository.object_info_get_set_value_function(this.__ref)
  def signal(N: Int): Ptr[Byte] = GIRepository.object_info_get_signal(this.__ref, N)
  def typeInit(): CString = GIRepository.object_info_get_type_init(this.__ref)
  def typeName(): CString = GIRepository.object_info_get_type_name(this.__ref)
  def unrefFunction(): CString = GIRepository.object_info_get_unref_function(this.__ref)
  def vfunc(N: Int): Ptr[Byte] = GIRepository.object_info_get_vfunc(this.__ref, N)

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

object ObjectInfo { def apply(__ref: Ptr[Byte]): ObjectInfo = new ObjectInfo(__ref) }

