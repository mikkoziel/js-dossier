// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dossier.proto

package com.github.jsdossier.proto;

/**
 * Protobuf type {@code dossier.SourceFile}
 *
 * <pre>
 * Describes a documented source file.
 * </pre>
 */
public final class SourceFile extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:dossier.SourceFile)
    SourceFileOrBuilder {
  // Use SourceFile.newBuilder() to construct.
  private SourceFile(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private SourceFile(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final SourceFile defaultInstance;
  public static SourceFile getDefaultInstance() {
    return defaultInstance;
  }

  public SourceFile getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private SourceFile(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            baseName_ = bs;
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            path_ = bs;
            break;
          }
          case 26: {
            com.google.protobuf.ByteString bs = input.readBytes();
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              lines_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000004;
            }
            lines_.add(bs);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        lines_ = lines_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.github.jsdossier.proto.Dossier.internal_static_dossier_SourceFile_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.github.jsdossier.proto.Dossier.internal_static_dossier_SourceFile_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.github.jsdossier.proto.SourceFile.class, com.github.jsdossier.proto.SourceFile.Builder.class);
  }

  public static com.google.protobuf.Parser<SourceFile> PARSER =
      new com.google.protobuf.AbstractParser<SourceFile>() {
    public SourceFile parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SourceFile(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<SourceFile> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int BASE_NAME_FIELD_NUMBER = 1;
  private java.lang.Object baseName_;
  /**
   * <code>required string base_name = 1;</code>
   *
   * <pre>
   * The file's base name.
   * </pre>
   */
  public boolean hasBaseName() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required string base_name = 1;</code>
   *
   * <pre>
   * The file's base name.
   * </pre>
   */
  public java.lang.String getBaseName() {
    java.lang.Object ref = baseName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        baseName_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string base_name = 1;</code>
   *
   * <pre>
   * The file's base name.
   * </pre>
   */
  public com.google.protobuf.ByteString
      getBaseNameBytes() {
    java.lang.Object ref = baseName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      baseName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PATH_FIELD_NUMBER = 2;
  private java.lang.Object path_;
  /**
   * <code>required string path = 2;</code>
   *
   * <pre>
   * The path to the file; may be relative to some unspecified directory.
   * </pre>
   */
  public boolean hasPath() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required string path = 2;</code>
   *
   * <pre>
   * The path to the file; may be relative to some unspecified directory.
   * </pre>
   */
  public java.lang.String getPath() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        path_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string path = 2;</code>
   *
   * <pre>
   * The path to the file; may be relative to some unspecified directory.
   * </pre>
   */
  public com.google.protobuf.ByteString
      getPathBytes() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      path_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LINES_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList lines_;
  /**
   * <code>repeated string lines = 3;</code>
   *
   * <pre>
   * The individual lines in the file. Each line should not be HTML escaped.
   * </pre>
   */
  public com.google.protobuf.ProtocolStringList
      getLinesList() {
    return lines_;
  }
  /**
   * <code>repeated string lines = 3;</code>
   *
   * <pre>
   * The individual lines in the file. Each line should not be HTML escaped.
   * </pre>
   */
  public int getLinesCount() {
    return lines_.size();
  }
  /**
   * <code>repeated string lines = 3;</code>
   *
   * <pre>
   * The individual lines in the file. Each line should not be HTML escaped.
   * </pre>
   */
  public java.lang.String getLines(int index) {
    return lines_.get(index);
  }
  /**
   * <code>repeated string lines = 3;</code>
   *
   * <pre>
   * The individual lines in the file. Each line should not be HTML escaped.
   * </pre>
   */
  public com.google.protobuf.ByteString
      getLinesBytes(int index) {
    return lines_.getByteString(index);
  }

  private void initFields() {
    baseName_ = "";
    path_ = "";
    lines_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasBaseName()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasPath()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeBytes(1, getBaseNameBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeBytes(2, getPathBytes());
    }
    for (int i = 0; i < lines_.size(); i++) {
      output.writeBytes(3, lines_.getByteString(i));
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, getBaseNameBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, getPathBytes());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < lines_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeBytesSizeNoTag(lines_.getByteString(i));
      }
      size += dataSize;
      size += 1 * getLinesList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static com.github.jsdossier.proto.SourceFile parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static com.github.jsdossier.proto.SourceFile parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static com.github.jsdossier.proto.SourceFile parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.github.jsdossier.proto.SourceFile parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(com.github.jsdossier.proto.SourceFile prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dossier.SourceFile}
   *
   * <pre>
   * Describes a documented source file.
   * </pre>
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dossier.SourceFile)
      com.github.jsdossier.proto.SourceFileOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.github.jsdossier.proto.Dossier.internal_static_dossier_SourceFile_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.github.jsdossier.proto.Dossier.internal_static_dossier_SourceFile_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.github.jsdossier.proto.SourceFile.class, com.github.jsdossier.proto.SourceFile.Builder.class);
    }

    // Construct using com.github.jsdossier.proto.SourceFile.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      baseName_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      path_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      lines_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.github.jsdossier.proto.Dossier.internal_static_dossier_SourceFile_descriptor;
    }

    public com.github.jsdossier.proto.SourceFile getDefaultInstanceForType() {
      return com.github.jsdossier.proto.SourceFile.getDefaultInstance();
    }

    public com.github.jsdossier.proto.SourceFile build() {
      com.github.jsdossier.proto.SourceFile result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.github.jsdossier.proto.SourceFile buildPartial() {
      com.github.jsdossier.proto.SourceFile result = new com.github.jsdossier.proto.SourceFile(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.baseName_ = baseName_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.path_ = path_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        lines_ = lines_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.lines_ = lines_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.github.jsdossier.proto.SourceFile) {
        return mergeFrom((com.github.jsdossier.proto.SourceFile)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.github.jsdossier.proto.SourceFile other) {
      if (other == com.github.jsdossier.proto.SourceFile.getDefaultInstance()) return this;
      if (other.hasBaseName()) {
        bitField0_ |= 0x00000001;
        baseName_ = other.baseName_;
        onChanged();
      }
      if (other.hasPath()) {
        bitField0_ |= 0x00000002;
        path_ = other.path_;
        onChanged();
      }
      if (!other.lines_.isEmpty()) {
        if (lines_.isEmpty()) {
          lines_ = other.lines_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureLinesIsMutable();
          lines_.addAll(other.lines_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      if (!hasBaseName()) {
        
        return false;
      }
      if (!hasPath()) {
        
        return false;
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.github.jsdossier.proto.SourceFile parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.github.jsdossier.proto.SourceFile) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object baseName_ = "";
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public boolean hasBaseName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public java.lang.String getBaseName() {
      java.lang.Object ref = baseName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          baseName_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public com.google.protobuf.ByteString
        getBaseNameBytes() {
      java.lang.Object ref = baseName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        baseName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public Builder setBaseName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      baseName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public Builder clearBaseName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      baseName_ = getDefaultInstance().getBaseName();
      onChanged();
      return this;
    }
    /**
     * <code>required string base_name = 1;</code>
     *
     * <pre>
     * The file's base name.
     * </pre>
     */
    public Builder setBaseNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      baseName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object path_ = "";
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public boolean hasPath() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          path_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public Builder setPath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      path_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public Builder clearPath() {
      bitField0_ = (bitField0_ & ~0x00000002);
      path_ = getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    /**
     * <code>required string path = 2;</code>
     *
     * <pre>
     * The path to the file; may be relative to some unspecified directory.
     * </pre>
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      path_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList lines_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureLinesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        lines_ = new com.google.protobuf.LazyStringArrayList(lines_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public com.google.protobuf.ProtocolStringList
        getLinesList() {
      return lines_.getUnmodifiableView();
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public int getLinesCount() {
      return lines_.size();
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public java.lang.String getLines(int index) {
      return lines_.get(index);
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public com.google.protobuf.ByteString
        getLinesBytes(int index) {
      return lines_.getByteString(index);
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public Builder setLines(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLinesIsMutable();
      lines_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public Builder addLines(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLinesIsMutable();
      lines_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public Builder addAllLines(
        java.lang.Iterable<java.lang.String> values) {
      ensureLinesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, lines_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public Builder clearLines() {
      lines_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string lines = 3;</code>
     *
     * <pre>
     * The individual lines in the file. Each line should not be HTML escaped.
     * </pre>
     */
    public Builder addLinesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLinesIsMutable();
      lines_.add(value);
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:dossier.SourceFile)
  }

  static {
    defaultInstance = new SourceFile(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:dossier.SourceFile)
}

