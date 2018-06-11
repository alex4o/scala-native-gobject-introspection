package GIRepository

import scala.scalanative.native._

@extern
@link("girepository-1.0")
object GIRepository {

	@name("g_arg_info_get_closure")
	def arg_info_get_closure(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_get_destroy")
	def arg_info_get_destroy(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_get_direction")
	def arg_info_get_direction(Info: Ptr[Byte]): CInt /* GIDirection */ = extern

	@name("g_arg_info_get_ownership_transfer")
	def arg_info_get_ownership_transfer(Info: Ptr[Byte]): CInt /* GITransfer */ = extern

	@name("g_arg_info_get_scope")
	def arg_info_get_scope(Info: Ptr[Byte]): CInt /* GIScopeType */ = extern

	@name("g_arg_info_get_type")
	def arg_info_get_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_arg_info_is_caller_allocates")
	def arg_info_is_caller_allocates(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_is_optional")
	def arg_info_is_optional(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_is_return_value")
	def arg_info_is_return_value(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_is_skip")
	def arg_info_is_skip(Info: Ptr[Byte]): CInt = extern

	@name("g_arg_info_load_type")
	def arg_info_load_type(Info: Ptr[Byte], Type: Ptr[Byte]): Unit = extern

	@name("g_arg_info_may_be_null")
	def arg_info_may_be_null(Info: Ptr[Byte]): CInt = extern

	@name("g_callable_info_can_throw_gerror")
	def callable_info_can_throw_gerror(Info: Ptr[Byte]): CInt = extern

	@name("g_callable_info_get_arg")
	def callable_info_get_arg(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_callable_info_get_caller_owns")
	def callable_info_get_caller_owns(Info: Ptr[Byte]): CInt /* GITransfer */ = extern

	@name("g_callable_info_get_instance_ownership_transfer")
	def callable_info_get_instance_ownership_transfer(Info: Ptr[Byte]): CInt /* GITransfer */ = extern

	@name("g_callable_info_get_n_args")
	def callable_info_get_n_args(Info: Ptr[Byte]): CInt = extern

	@name("g_callable_info_get_return_attribute")
	def callable_info_get_return_attribute(Info: Ptr[Byte], Name: CString): CString = extern

	@name("g_callable_info_get_return_type")
	def callable_info_get_return_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_callable_info_invoke")
	def callable_info_invoke(Info: Ptr[Byte], Function: Ptr[Byte], Inargs: Ptr[Ptr[Byte]], Ninargs: CInt, Outargs: Ptr[Ptr[Byte]], Noutargs: CInt, Returnvalue: Ptr[Byte], Ismethod: CInt, Throws: CInt): CInt = extern

	@name("g_callable_info_is_method")
	def callable_info_is_method(Info: Ptr[Byte]): CInt = extern

	@name("g_callable_info_iterate_return_attributes")
	def callable_info_iterate_return_attributes(Info: Ptr[Byte], Iterator: Ptr[Byte], Name: Ptr[CString], Value: Ptr[CString]): CInt = extern

	@name("g_callable_info_load_arg")
	def callable_info_load_arg(Info: Ptr[Byte], N: CInt, Arg: Ptr[Byte]): Unit = extern

	@name("g_callable_info_load_return_type")
	def callable_info_load_return_type(Info: Ptr[Byte], Type: Ptr[Byte]): Unit = extern

	@name("g_callable_info_may_return_null")
	def callable_info_may_return_null(Info: Ptr[Byte]): CInt = extern

	@name("g_callable_info_skip_return")
	def callable_info_skip_return(Info: Ptr[Byte]): CInt = extern

	@name("g_constant_info_free_value")
	def constant_info_free_value(Info: Ptr[Byte], Value: Ptr[Byte]): Unit = extern

	@name("g_constant_info_get_type")
	def constant_info_get_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_constant_info_get_value")
	def constant_info_get_value(Info: Ptr[Byte], Value: Ptr[Byte]): CInt = extern

	@name("g_enum_info_get_error_domain")
	def enum_info_get_error_domain(Info: Ptr[Byte]): CString = extern

	@name("g_enum_info_get_method")
	def enum_info_get_method(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_enum_info_get_n_methods")
	def enum_info_get_n_methods(Info: Ptr[Byte]): CInt = extern

	@name("g_enum_info_get_n_values")
	def enum_info_get_n_values(Info: Ptr[Byte]): CInt = extern

	@name("g_enum_info_get_storage_type")
	def enum_info_get_storage_type(Info: Ptr[Byte]): CInt /* GITypeTag */ = extern

	@name("g_enum_info_get_value")
	def enum_info_get_value(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_field_info_get_field")
	def field_info_get_field(Fieldinfo: Ptr[Byte], Mem: Ptr[Byte], Value: Ptr[Byte]): CInt = extern

	@name("g_field_info_get_flags")
	def field_info_get_flags(Info: Ptr[Byte]): CInt /* GIFieldInfoFlags */ = extern

	@name("g_field_info_get_offset")
	def field_info_get_offset(Info: Ptr[Byte]): CInt = extern

	@name("g_field_info_get_size")
	def field_info_get_size(Info: Ptr[Byte]): CInt = extern

	@name("g_field_info_get_type")
	def field_info_get_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_field_info_set_field")
	def field_info_set_field(Fieldinfo: Ptr[Byte], Mem: Ptr[Byte], Value: Ptr[Byte]): CInt = extern

	@name("g_function_info_get_flags")
	def function_info_get_flags(Info: Ptr[Byte]): CInt /* GIFunctionInfoFlags */ = extern

	@name("g_function_info_get_property")
	def function_info_get_property(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_function_info_get_symbol")
	def function_info_get_symbol(Info: Ptr[Byte]): CString = extern

	@name("g_function_info_get_vfunc")
	def function_info_get_vfunc(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_function_info_invoke")
	def function_info_invoke(Info: Ptr[Byte], Inargs: Ptr[Ptr[Byte]], Ninargs: CInt, Outargs: Ptr[Ptr[Byte]], Noutargs: CInt, Returnvalue: Ptr[Byte]): CInt = extern

	@name("g_info_new")
	def info_new(Type: CInt /* GIInfoType */, Container: Ptr[Byte], Typelib: Ptr[Byte], Offset: CUnsignedInt): Ptr[Byte] = extern

	@name("g_info_type_to_string")
	def info_type_to_string(Type: CInt /* GIInfoType */): CString = extern

	@name("g_interface_info_find_method")
	def interface_info_find_method(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_interface_info_find_signal")
	def interface_info_find_signal(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_interface_info_find_vfunc")
	def interface_info_find_vfunc(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_interface_info_get_constant")
	def interface_info_get_constant(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_interface_info_get_iface_struct")
	def interface_info_get_iface_struct(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_interface_info_get_method")
	def interface_info_get_method(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_interface_info_get_n_constants")
	def interface_info_get_n_constants(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_n_methods")
	def interface_info_get_n_methods(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_n_prerequisites")
	def interface_info_get_n_prerequisites(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_n_properties")
	def interface_info_get_n_properties(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_n_signals")
	def interface_info_get_n_signals(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_n_vfuncs")
	def interface_info_get_n_vfuncs(Info: Ptr[Byte]): CInt = extern

	@name("g_interface_info_get_prerequisite")
	def interface_info_get_prerequisite(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_interface_info_get_property")
	def interface_info_get_property(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_interface_info_get_signal")
	def interface_info_get_signal(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_interface_info_get_vfunc")
	def interface_info_get_vfunc(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_invoke_error_quark")
	def invoke_error_quark(): CInt /* GQuark */ = extern

	@name("g_object_info_find_method")
	def object_info_find_method(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_object_info_find_method_using_interfaces")
	def object_info_find_method_using_interfaces(Info: Ptr[Byte], Name: CString, Implementor: Ptr[Ptr[Byte]]): Ptr[Byte] = extern

	@name("g_object_info_find_signal")
	def object_info_find_signal(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_object_info_find_vfunc")
	def object_info_find_vfunc(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_object_info_find_vfunc_using_interfaces")
	def object_info_find_vfunc_using_interfaces(Info: Ptr[Byte], Name: CString, Implementor: Ptr[Ptr[Byte]]): Ptr[Byte] = extern

	@name("g_object_info_get_abstract")
	def object_info_get_abstract(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_class_struct")
	def object_info_get_class_struct(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_object_info_get_constant")
	def object_info_get_constant(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_field")
	def object_info_get_field(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_fundamental")
	def object_info_get_fundamental(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_get_value_function")
	def object_info_get_get_value_function(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_get_value_function_pointer")
	def object_info_get_get_value_function_pointer(Info: Ptr[Byte]): CInt /* GIObjectInfoGetValueFunction */ = extern

	@name("g_object_info_get_interface")
	def object_info_get_interface(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_method")
	def object_info_get_method(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_n_constants")
	def object_info_get_n_constants(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_fields")
	def object_info_get_n_fields(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_interfaces")
	def object_info_get_n_interfaces(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_methods")
	def object_info_get_n_methods(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_properties")
	def object_info_get_n_properties(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_signals")
	def object_info_get_n_signals(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_n_vfuncs")
	def object_info_get_n_vfuncs(Info: Ptr[Byte]): CInt = extern

	@name("g_object_info_get_parent")
	def object_info_get_parent(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_object_info_get_property")
	def object_info_get_property(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_ref_function")
	def object_info_get_ref_function(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_ref_function_pointer")
	def object_info_get_ref_function_pointer(Info: Ptr[Byte]): CInt /* GIObjectInfoRefFunction */ = extern

	@name("g_object_info_get_set_value_function")
	def object_info_get_set_value_function(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_set_value_function_pointer")
	def object_info_get_set_value_function_pointer(Info: Ptr[Byte]): CInt /* GIObjectInfoSetValueFunction */ = extern

	@name("g_object_info_get_signal")
	def object_info_get_signal(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_object_info_get_type_init")
	def object_info_get_type_init(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_type_name")
	def object_info_get_type_name(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_unref_function")
	def object_info_get_unref_function(Info: Ptr[Byte]): CString = extern

	@name("g_object_info_get_unref_function_pointer")
	def object_info_get_unref_function_pointer(Info: Ptr[Byte]): CInt /* GIObjectInfoUnrefFunction */ = extern

	@name("g_object_info_get_vfunc")
	def object_info_get_vfunc(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_property_info_get_flags")
	def property_info_get_flags(Info: Ptr[Byte]): CInt /* GParamFlags */ = extern

	@name("g_property_info_get_ownership_transfer")
	def property_info_get_ownership_transfer(Info: Ptr[Byte]): CInt /* GITransfer */ = extern

	@name("g_property_info_get_type")
	def property_info_get_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_registered_type_info_get_g_type")
	def registered_type_info_get_g_type(Info: Ptr[Byte]): CInt /* GType */ = extern

	@name("g_registered_type_info_get_type_init")
	def registered_type_info_get_type_init(Info: Ptr[Byte]): CString = extern

	@name("g_registered_type_info_get_type_name")
	def registered_type_info_get_type_name(Info: Ptr[Byte]): CString = extern

	@name("g_signal_info_get_class_closure")
	def signal_info_get_class_closure(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_signal_info_get_flags")
	def signal_info_get_flags(Info: Ptr[Byte]): CInt /* GSignalFlags */ = extern

	@name("g_signal_info_true_stops_emit")
	def signal_info_true_stops_emit(Info: Ptr[Byte]): CInt = extern

	@name("g_struct_info_find_field")
	def struct_info_find_field(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_struct_info_find_method")
	def struct_info_find_method(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_struct_info_get_alignment")
	def struct_info_get_alignment(Info: Ptr[Byte]): CSize = extern

	@name("g_struct_info_get_field")
	def struct_info_get_field(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_struct_info_get_method")
	def struct_info_get_method(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_struct_info_get_n_fields")
	def struct_info_get_n_fields(Info: Ptr[Byte]): CInt = extern

	@name("g_struct_info_get_n_methods")
	def struct_info_get_n_methods(Info: Ptr[Byte]): CInt = extern

	@name("g_struct_info_get_size")
	def struct_info_get_size(Info: Ptr[Byte]): CSize = extern

	@name("g_struct_info_is_foreign")
	def struct_info_is_foreign(Info: Ptr[Byte]): CInt = extern

	@name("g_struct_info_is_gtype_struct")
	def struct_info_is_gtype_struct(Info: Ptr[Byte]): CInt = extern

	@name("g_type_info_get_array_fixed_size")
	def type_info_get_array_fixed_size(Info: Ptr[Byte]): CInt = extern

	@name("g_type_info_get_array_length")
	def type_info_get_array_length(Info: Ptr[Byte]): CInt = extern

	@name("g_type_info_get_array_type")
	def type_info_get_array_type(Info: Ptr[Byte]): CInt /* GIArrayType */ = extern

	@name("g_type_info_get_interface")
	def type_info_get_interface(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_type_info_get_param_type")
	def type_info_get_param_type(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_type_info_get_tag")
	def type_info_get_tag(Info: Ptr[Byte]): CInt /* GITypeTag */ = extern

	@name("g_type_info_is_pointer")
	def type_info_is_pointer(Info: Ptr[Byte]): CInt = extern

	@name("g_type_info_is_zero_terminated")
	def type_info_is_zero_terminated(Info: Ptr[Byte]): CInt = extern

	@name("g_type_tag_to_string")
	def type_tag_to_string(Type: CInt /* GITypeTag */): CString = extern

	@name("g_union_info_find_method")
	def union_info_find_method(Info: Ptr[Byte], Name: CString): Ptr[Byte] = extern

	@name("g_union_info_get_alignment")
	def union_info_get_alignment(Info: Ptr[Byte]): CSize = extern

	@name("g_union_info_get_discriminator")
	def union_info_get_discriminator(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_union_info_get_discriminator_offset")
	def union_info_get_discriminator_offset(Info: Ptr[Byte]): CInt = extern

	@name("g_union_info_get_discriminator_type")
	def union_info_get_discriminator_type(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_union_info_get_field")
	def union_info_get_field(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_union_info_get_method")
	def union_info_get_method(Info: Ptr[Byte], N: CInt): Ptr[Byte] = extern

	@name("g_union_info_get_n_fields")
	def union_info_get_n_fields(Info: Ptr[Byte]): CInt = extern

	@name("g_union_info_get_n_methods")
	def union_info_get_n_methods(Info: Ptr[Byte]): CInt = extern

	@name("g_union_info_get_size")
	def union_info_get_size(Info: Ptr[Byte]): CSize = extern

	@name("g_union_info_is_discriminated")
	def union_info_is_discriminated(Info: Ptr[Byte]): CInt = extern

	@name("g_value_info_get_value")
	def value_info_get_value(Info: Ptr[Byte]): CInt = extern

	@name("g_vfunc_info_get_address")
	def vfunc_info_get_address(Info: Ptr[Byte], Implementorgtype: CInt /* GType */): Ptr[Byte] = extern

	@name("g_vfunc_info_get_flags")
	def vfunc_info_get_flags(Info: Ptr[Byte]): CInt /* GIVFuncInfoFlags */ = extern

	@name("g_vfunc_info_get_invoker")
	def vfunc_info_get_invoker(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_vfunc_info_get_offset")
	def vfunc_info_get_offset(Info: Ptr[Byte]): CInt = extern

	@name("g_vfunc_info_get_signal")
	def vfunc_info_get_signal(Info: Ptr[Byte]): Ptr[Byte] = extern

	@name("g_vfunc_info_invoke")
	def vfunc_info_invoke(Info: Ptr[Byte], Implementor: CInt /* GType */, Inargs: Ptr[Ptr[Byte]], Ninargs: CInt, Outargs: Ptr[Ptr[Byte]], Noutargs: CInt, Returnvalue: Ptr[Byte]): CInt = extern

}
