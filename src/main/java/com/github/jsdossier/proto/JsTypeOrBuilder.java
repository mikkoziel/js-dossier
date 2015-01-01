// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dossier.proto

package com.github.jsdossier.proto;

public interface JsTypeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dossier.JsType)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required string name = 1;</code>
   */
  boolean hasName();
  /**
   * <code>required string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>required string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>required .dossier.SourceLink source = 5;</code>
   */
  boolean hasSource();
  /**
   * <code>required .dossier.SourceLink source = 5;</code>
   */
  com.github.jsdossier.proto.SourceLink getSource();
  /**
   * <code>required .dossier.SourceLink source = 5;</code>
   */
  com.github.jsdossier.proto.SourceLinkOrBuilder getSourceOrBuilder();

  /**
   * <code>repeated .dossier.JsType.TypeSummary nested = 6;</code>
   */
  java.util.List<com.github.jsdossier.proto.JsType.TypeSummary> 
      getNestedList();
  /**
   * <code>repeated .dossier.JsType.TypeSummary nested = 6;</code>
   */
  com.github.jsdossier.proto.JsType.TypeSummary getNested(int index);
  /**
   * <code>repeated .dossier.JsType.TypeSummary nested = 6;</code>
   */
  int getNestedCount();
  /**
   * <code>repeated .dossier.JsType.TypeSummary nested = 6;</code>
   */
  java.util.List<? extends com.github.jsdossier.proto.JsType.TypeSummaryOrBuilder> 
      getNestedOrBuilderList();
  /**
   * <code>repeated .dossier.JsType.TypeSummary nested = 6;</code>
   */
  com.github.jsdossier.proto.JsType.TypeSummaryOrBuilder getNestedOrBuilder(
      int index);

  /**
   * <code>required .dossier.Comment description = 7;</code>
   */
  boolean hasDescription();
  /**
   * <code>required .dossier.Comment description = 7;</code>
   */
  com.github.jsdossier.proto.Comment getDescription();
  /**
   * <code>required .dossier.Comment description = 7;</code>
   */
  com.github.jsdossier.proto.CommentOrBuilder getDescriptionOrBuilder();

  /**
   * <code>required .dossier.Tags tags = 8;</code>
   */
  boolean hasTags();
  /**
   * <code>required .dossier.Tags tags = 8;</code>
   */
  com.github.jsdossier.proto.Tags getTags();
  /**
   * <code>required .dossier.Tags tags = 8;</code>
   */
  com.github.jsdossier.proto.TagsOrBuilder getTagsOrBuilder();

  /**
   * <code>optional .dossier.Deprecation deprecation = 9;</code>
   */
  boolean hasDeprecation();
  /**
   * <code>optional .dossier.Deprecation deprecation = 9;</code>
   */
  com.github.jsdossier.proto.Deprecation getDeprecation();
  /**
   * <code>optional .dossier.Deprecation deprecation = 9;</code>
   */
  com.github.jsdossier.proto.DeprecationOrBuilder getDeprecationOrBuilder();

  /**
   * <code>repeated .dossier.JsType.TypeDef type_def = 10;</code>
   */
  java.util.List<com.github.jsdossier.proto.JsType.TypeDef> 
      getTypeDefList();
  /**
   * <code>repeated .dossier.JsType.TypeDef type_def = 10;</code>
   */
  com.github.jsdossier.proto.JsType.TypeDef getTypeDef(int index);
  /**
   * <code>repeated .dossier.JsType.TypeDef type_def = 10;</code>
   */
  int getTypeDefCount();
  /**
   * <code>repeated .dossier.JsType.TypeDef type_def = 10;</code>
   */
  java.util.List<? extends com.github.jsdossier.proto.JsType.TypeDefOrBuilder> 
      getTypeDefOrBuilderList();
  /**
   * <code>repeated .dossier.JsType.TypeDef type_def = 10;</code>
   */
  com.github.jsdossier.proto.JsType.TypeDefOrBuilder getTypeDefOrBuilder(
      int index);

  /**
   * <code>optional .dossier.Enumeration enumeration = 11;</code>
   */
  boolean hasEnumeration();
  /**
   * <code>optional .dossier.Enumeration enumeration = 11;</code>
   */
  com.github.jsdossier.proto.Enumeration getEnumeration();
  /**
   * <code>optional .dossier.Enumeration enumeration = 11;</code>
   */
  com.github.jsdossier.proto.EnumerationOrBuilder getEnumerationOrBuilder();

  /**
   * <code>repeated .dossier.Function static_function = 12;</code>
   */
  java.util.List<com.github.jsdossier.proto.Function> 
      getStaticFunctionList();
  /**
   * <code>repeated .dossier.Function static_function = 12;</code>
   */
  com.github.jsdossier.proto.Function getStaticFunction(int index);
  /**
   * <code>repeated .dossier.Function static_function = 12;</code>
   */
  int getStaticFunctionCount();
  /**
   * <code>repeated .dossier.Function static_function = 12;</code>
   */
  java.util.List<? extends com.github.jsdossier.proto.FunctionOrBuilder> 
      getStaticFunctionOrBuilderList();
  /**
   * <code>repeated .dossier.Function static_function = 12;</code>
   */
  com.github.jsdossier.proto.FunctionOrBuilder getStaticFunctionOrBuilder(
      int index);

  /**
   * <code>repeated .dossier.Property static_property = 13;</code>
   */
  java.util.List<com.github.jsdossier.proto.Property> 
      getStaticPropertyList();
  /**
   * <code>repeated .dossier.Property static_property = 13;</code>
   */
  com.github.jsdossier.proto.Property getStaticProperty(int index);
  /**
   * <code>repeated .dossier.Property static_property = 13;</code>
   */
  int getStaticPropertyCount();
  /**
   * <code>repeated .dossier.Property static_property = 13;</code>
   */
  java.util.List<? extends com.github.jsdossier.proto.PropertyOrBuilder> 
      getStaticPropertyOrBuilderList();
  /**
   * <code>repeated .dossier.Property static_property = 13;</code>
   */
  com.github.jsdossier.proto.PropertyOrBuilder getStaticPropertyOrBuilder(
      int index);

  /**
   * <code>optional .dossier.Function main_function = 14;</code>
   *
   * <pre>
   * Describes the main function for this type. This is typically a class
   * constructor, but may also be the main function for a namespace (which
   * all other properties are hung off of).
   * </pre>
   */
  boolean hasMainFunction();
  /**
   * <code>optional .dossier.Function main_function = 14;</code>
   *
   * <pre>
   * Describes the main function for this type. This is typically a class
   * constructor, but may also be the main function for a namespace (which
   * all other properties are hung off of).
   * </pre>
   */
  com.github.jsdossier.proto.Function getMainFunction();
  /**
   * <code>optional .dossier.Function main_function = 14;</code>
   *
   * <pre>
   * Describes the main function for this type. This is typically a class
   * constructor, but may also be the main function for a namespace (which
   * all other properties are hung off of).
   * </pre>
   */
  com.github.jsdossier.proto.FunctionOrBuilder getMainFunctionOrBuilder();

  /**
   * <code>repeated .dossier.Function method = 15;</code>
   *
   * <pre>
   * Instance methods for this type.
   * </pre>
   */
  java.util.List<com.github.jsdossier.proto.Function> 
      getMethodList();
  /**
   * <code>repeated .dossier.Function method = 15;</code>
   *
   * <pre>
   * Instance methods for this type.
   * </pre>
   */
  com.github.jsdossier.proto.Function getMethod(int index);
  /**
   * <code>repeated .dossier.Function method = 15;</code>
   *
   * <pre>
   * Instance methods for this type.
   * </pre>
   */
  int getMethodCount();
  /**
   * <code>repeated .dossier.Function method = 15;</code>
   *
   * <pre>
   * Instance methods for this type.
   * </pre>
   */
  java.util.List<? extends com.github.jsdossier.proto.FunctionOrBuilder> 
      getMethodOrBuilderList();
  /**
   * <code>repeated .dossier.Function method = 15;</code>
   *
   * <pre>
   * Instance methods for this type.
   * </pre>
   */
  com.github.jsdossier.proto.FunctionOrBuilder getMethodOrBuilder(
      int index);

  /**
   * <code>repeated .dossier.Property field = 16;</code>
   *
   * <pre>
   * Instance properties for this type.
   * </pre>
   */
  java.util.List<com.github.jsdossier.proto.Property> 
      getFieldList();
  /**
   * <code>repeated .dossier.Property field = 16;</code>
   *
   * <pre>
   * Instance properties for this type.
   * </pre>
   */
  com.github.jsdossier.proto.Property getField(int index);
  /**
   * <code>repeated .dossier.Property field = 16;</code>
   *
   * <pre>
   * Instance properties for this type.
   * </pre>
   */
  int getFieldCount();
  /**
   * <code>repeated .dossier.Property field = 16;</code>
   *
   * <pre>
   * Instance properties for this type.
   * </pre>
   */
  java.util.List<? extends com.github.jsdossier.proto.PropertyOrBuilder> 
      getFieldOrBuilderList();
  /**
   * <code>repeated .dossier.Property field = 16;</code>
   *
   * <pre>
   * Instance properties for this type.
   * </pre>
   */
  com.github.jsdossier.proto.PropertyOrBuilder getFieldOrBuilder(
      int index);

  /**
   * <code>repeated .dossier.Comment extended_type = 18;</code>
   *
   * <pre>
   * List of inherited types for a class. This should be empty if |is_class|
   * is false. Classes should be listed in order, with the root type first.
   * </pre>
   */
  java.util.List<com.github.jsdossier.proto.Comment> 
      getExtendedTypeList();
  /**
   * <code>repeated .dossier.Comment extended_type = 18;</code>
   *
   * <pre>
   * List of inherited types for a class. This should be empty if |is_class|
   * is false. Classes should be listed in order, with the root type first.
   * </pre>
   */
  com.github.jsdossier.proto.Comment getExtendedType(int index);
  /**
   * <code>repeated .dossier.Comment extended_type = 18;</code>
   *
   * <pre>
   * List of inherited types for a class. This should be empty if |is_class|
   * is false. Classes should be listed in order, with the root type first.
   * </pre>
   */
  int getExtendedTypeCount();
  /**
   * <code>repeated .dossier.Comment extended_type = 18;</code>
   *
   * <pre>
   * List of inherited types for a class. This should be empty if |is_class|
   * is false. Classes should be listed in order, with the root type first.
   * </pre>
   */
  java.util.List<? extends com.github.jsdossier.proto.CommentOrBuilder> 
      getExtendedTypeOrBuilderList();
  /**
   * <code>repeated .dossier.Comment extended_type = 18;</code>
   *
   * <pre>
   * List of inherited types for a class. This should be empty if |is_class|
   * is false. Classes should be listed in order, with the root type first.
   * </pre>
   */
  com.github.jsdossier.proto.CommentOrBuilder getExtendedTypeOrBuilder(
      int index);

  /**
   * <code>repeated .dossier.Comment implemented_type = 19;</code>
   *
   * <pre>
   * The interfaces implemented by a class/extended by an interface. This
   * list should be empty if |is_class| and |is_interface| are false.
   * </pre>
   */
  java.util.List<com.github.jsdossier.proto.Comment> 
      getImplementedTypeList();
  /**
   * <code>repeated .dossier.Comment implemented_type = 19;</code>
   *
   * <pre>
   * The interfaces implemented by a class/extended by an interface. This
   * list should be empty if |is_class| and |is_interface| are false.
   * </pre>
   */
  com.github.jsdossier.proto.Comment getImplementedType(int index);
  /**
   * <code>repeated .dossier.Comment implemented_type = 19;</code>
   *
   * <pre>
   * The interfaces implemented by a class/extended by an interface. This
   * list should be empty if |is_class| and |is_interface| are false.
   * </pre>
   */
  int getImplementedTypeCount();
  /**
   * <code>repeated .dossier.Comment implemented_type = 19;</code>
   *
   * <pre>
   * The interfaces implemented by a class/extended by an interface. This
   * list should be empty if |is_class| and |is_interface| are false.
   * </pre>
   */
  java.util.List<? extends com.github.jsdossier.proto.CommentOrBuilder> 
      getImplementedTypeOrBuilderList();
  /**
   * <code>repeated .dossier.Comment implemented_type = 19;</code>
   *
   * <pre>
   * The interfaces implemented by a class/extended by an interface. This
   * list should be empty if |is_class| and |is_interface| are false.
   * </pre>
   */
  com.github.jsdossier.proto.CommentOrBuilder getImplementedTypeOrBuilder(
      int index);

  /**
   * <code>repeated .dossier.Property compiler_constant = 20;</code>
   */
  java.util.List<com.github.jsdossier.proto.Property> 
      getCompilerConstantList();
  /**
   * <code>repeated .dossier.Property compiler_constant = 20;</code>
   */
  com.github.jsdossier.proto.Property getCompilerConstant(int index);
  /**
   * <code>repeated .dossier.Property compiler_constant = 20;</code>
   */
  int getCompilerConstantCount();
  /**
   * <code>repeated .dossier.Property compiler_constant = 20;</code>
   */
  java.util.List<? extends com.github.jsdossier.proto.PropertyOrBuilder> 
      getCompilerConstantOrBuilderList();
  /**
   * <code>repeated .dossier.Property compiler_constant = 20;</code>
   */
  com.github.jsdossier.proto.PropertyOrBuilder getCompilerConstantOrBuilder(
      int index);

  /**
   * <code>optional .dossier.JsType.ParentLink parent = 21;</code>
   */
  boolean hasParent();
  /**
   * <code>optional .dossier.JsType.ParentLink parent = 21;</code>
   */
  com.github.jsdossier.proto.JsType.ParentLink getParent();
  /**
   * <code>optional .dossier.JsType.ParentLink parent = 21;</code>
   */
  com.github.jsdossier.proto.JsType.ParentLinkOrBuilder getParentOrBuilder();

  /**
   * <code>optional .dossier.TypeLink aliased_type = 22;</code>
   *
   * <pre>
   * Link to another type that this type is an alias of.
   * </pre>
   */
  boolean hasAliasedType();
  /**
   * <code>optional .dossier.TypeLink aliased_type = 22;</code>
   *
   * <pre>
   * Link to another type that this type is an alias of.
   * </pre>
   */
  com.github.jsdossier.proto.TypeLink getAliasedType();
  /**
   * <code>optional .dossier.TypeLink aliased_type = 22;</code>
   *
   * <pre>
   * Link to another type that this type is an alias of.
   * </pre>
   */
  com.github.jsdossier.proto.TypeLinkOrBuilder getAliasedTypeOrBuilder();
}
