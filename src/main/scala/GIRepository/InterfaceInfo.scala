package GIRepository 

import scala.scalanative.native._

class InterfaceInfo(override val __ref: Ptr[Byte]) extends BaseInfo(__ref) {
  def findMethod(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.interface_info_find_method(this.__ref, toCString(Name))
  }
  def findSignal(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.interface_info_find_signal(this.__ref, toCString(Name))
  }
  def findVfunc(Info: BaseInfo, Name: String): Ptr[Byte] = Zone { implicit z => 
    GIRepository.interface_info_find_vfunc(this.__ref, toCString(Name))
  }
  def constant(N: Int): Ptr[Byte] = GIRepository.interface_info_get_constant(this.__ref, N)
  def ifaceStruct(): Ptr[Byte] = GIRepository.interface_info_get_iface_struct(this.__ref)
  def method(N: Int): Ptr[Byte] = GIRepository.interface_info_get_method(this.__ref, N)
  def nConstants(): CInt = GIRepository.interface_info_get_n_constants(this.__ref)
  def nMethods(): CInt = GIRepository.interface_info_get_n_methods(this.__ref)
  def nPrerequisites(): CInt = GIRepository.interface_info_get_n_prerequisites(this.__ref)
  def nProperties(): CInt = GIRepository.interface_info_get_n_properties(this.__ref)
  def nSignals(): CInt = GIRepository.interface_info_get_n_signals(this.__ref)
  def nVfuncs(): CInt = GIRepository.interface_info_get_n_vfuncs(this.__ref)
  def prerequisite(N: Int): Ptr[Byte] = GIRepository.interface_info_get_prerequisite(this.__ref, N)
  def property(N: Int): Ptr[Byte] = GIRepository.interface_info_get_property(this.__ref, N)
  def signal(N: Int): Ptr[Byte] = GIRepository.interface_info_get_signal(this.__ref, N)
  def vfunc(N: Int): Ptr[Byte] = GIRepository.interface_info_get_vfunc(this.__ref, N)
}

object InterfaceInfo { def apply(__ref: Ptr[Byte]): InterfaceInfo = new InterfaceInfo(__ref) }

