// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: expression.proto

package com.github.jsdossier.proto;

public final class Expression {
  private Expression() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_FunctionType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_FunctionType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_TypeLink_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_TypeLink_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_NamedType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_NamedType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_UnionType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_UnionType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_RecordType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_RecordType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_RecordType_Entry_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_RecordType_Entry_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_dossier_expression_TypeExpression_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_dossier_expression_TypeExpression_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020expression.proto\022\022dossier.expression\032\r" +
      "options.proto\"\321\001\n\014FunctionType\022\026\n\016is_con" +
      "structor\030\001 \001(\010\0229\n\rinstance_type\030\002 \001(\0132\"." +
      "dossier.expression.TypeExpression\0225\n\tpar" +
      "ameter\030\003 \003(\0132\".dossier.expression.TypeEx" +
      "pression\0227\n\013return_type\030\004 \001(\0132\".dossier." +
      "expression.TypeExpression\"6\n\010TypeLink\022\024\n" +
      "\004href\030\001 \001(\tB\006\362\201\031\002\010\001\022\024\n\004json\030\002 \001(\tB\006\362\201\031\002\010" +
      "\001\"\250\001\n\tNamedType\022\014\n\004name\030\001 \001(\t\022\026\n\016qualifi" +
      "ed_name\030\002 \001(\t\022*\n\004link\030\003 \001(\0132\034.dossier.ex",
      "pression.TypeLink\022\016\n\006extern\030\004 \001(\010\0229\n\rtem" +
      "plate_type\030\005 \003(\0132\".dossier.expression.Ty" +
      "peExpression\"=\n\tUnionType\0220\n\004type\030\001 \003(\0132" +
      "\".dossier.expression.TypeExpression\"\212\001\n\n" +
      "RecordType\0223\n\005entry\030\001 \003(\0132$.dossier.expr" +
      "ession.RecordType.Entry\032G\n\005Entry\022\013\n\003key\030" +
      "\001 \001(\t\0221\n\005value\030\002 \001(\0132\".dossier.expressio" +
      "n.TypeExpression\"\210\003\n\016TypeExpression\022\025\n\013i" +
      "s_optional\030\001 \001(\010H\000\022\024\n\nis_varargs\030\002 \001(\010H\000" +
      "\0229\n\rfunction_type\030\003 \001(\0132 .dossier.expres",
      "sion.FunctionTypeH\001\0223\n\nnamed_type\030\004 \001(\0132" +
      "\035.dossier.expression.NamedTypeH\001\0225\n\013reco" +
      "rd_type\030\005 \001(\0132\036.dossier.expression.Recor" +
      "dTypeH\001\0223\n\nunion_type\030\006 \001(\0132\035.dossier.ex" +
      "pression.UnionTypeH\001\022\022\n\010any_type\030\007 \001(\010H\001" +
      "\022\026\n\014unknown_type\030\010 \001(\010H\001\022\023\n\tvoid_type\030\t " +
      "\001(\010H\001\022\023\n\tnull_type\030\n \001(\010H\001B\n\n\010modifierB\013" +
      "\n\tnode_typeB\036\n\032com.github.jsdossier.prot" +
      "oP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.github.jsdossier.proto.Options.getDescriptor(),
        }, assigner);
    internal_static_dossier_expression_FunctionType_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dossier_expression_FunctionType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_FunctionType_descriptor,
        new java.lang.String[] { "IsConstructor", "InstanceType", "Parameter", "ReturnType", });
    internal_static_dossier_expression_TypeLink_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_dossier_expression_TypeLink_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_TypeLink_descriptor,
        new java.lang.String[] { "Href", "Json", });
    internal_static_dossier_expression_NamedType_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_dossier_expression_NamedType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_NamedType_descriptor,
        new java.lang.String[] { "Name", "QualifiedName", "Link", "Extern", "TemplateType", });
    internal_static_dossier_expression_UnionType_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_dossier_expression_UnionType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_UnionType_descriptor,
        new java.lang.String[] { "Type", });
    internal_static_dossier_expression_RecordType_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_dossier_expression_RecordType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_RecordType_descriptor,
        new java.lang.String[] { "Entry", });
    internal_static_dossier_expression_RecordType_Entry_descriptor =
      internal_static_dossier_expression_RecordType_descriptor.getNestedTypes().get(0);
    internal_static_dossier_expression_RecordType_Entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_RecordType_Entry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_dossier_expression_TypeExpression_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_dossier_expression_TypeExpression_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_dossier_expression_TypeExpression_descriptor,
        new java.lang.String[] { "IsOptional", "IsVarargs", "FunctionType", "NamedType", "RecordType", "UnionType", "AnyType", "UnknownType", "VoidType", "NullType", "Modifier", "NodeType", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.github.jsdossier.proto.Options.sanitized);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.github.jsdossier.proto.Options.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
