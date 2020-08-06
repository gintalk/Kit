/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vng.zing.media.mp3.publisher.mw.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TPublisherMWWriteService {

  public interface Iface extends TPublisherMWReadService.Iface {

    public int putAsset(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req) throws org.apache.thrift.TException;

  }

  public interface AsyncIface extends TPublisherMWReadService .AsyncIface {

    public void putAsset(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.putAsset_call> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends TPublisherMWReadService.Client implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public int putAsset(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req) throws org.apache.thrift.TException
    {
      send_putAsset(auth, req);
      return recv_putAsset();
    }

    public void send_putAsset(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req) throws org.apache.thrift.TException
    {
      putAsset_args args = new putAsset_args();
      args.setAuth(auth);
      args.setReq(req);
      sendBase("putAsset", args);
    }

    public int recv_putAsset() throws org.apache.thrift.TException
    {
      putAsset_result result = new putAsset_result();
      receiveBase(result, "putAsset");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "putAsset failed: unknown result");
    }

  }
  public static class AsyncClient extends TPublisherMWReadService.AsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void putAsset(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req, org.apache.thrift.async.AsyncMethodCallback<putAsset_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      putAsset_call method_call = new putAsset_call(auth, req, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class putAsset_call extends org.apache.thrift.async.TAsyncMethodCall {
      private com.vng.zing.media.common.thrift.TThriftAuth auth;
      private com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req;
      public putAsset_call(com.vng.zing.media.common.thrift.TThriftAuth auth, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req, org.apache.thrift.async.AsyncMethodCallback<putAsset_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.auth = auth;
        this.req = req;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("putAsset", org.apache.thrift.protocol.TMessageType.CALL, 0));
        putAsset_args args = new putAsset_args();
        args.setAuth(auth);
        args.setReq(req);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public int getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_putAsset();
      }
    }

  }

  public static class Processor<I extends Iface> extends TPublisherMWReadService.Processor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("putAsset", new putAsset());
      return processMap;
    }

    public static class putAsset<I extends Iface> extends org.apache.thrift.ProcessFunction<I, putAsset_args> {
      public putAsset() {
        super("putAsset");
      }

      public putAsset_args getEmptyArgsInstance() {
        return new putAsset_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public putAsset_result getResult(I iface, putAsset_args args) throws org.apache.thrift.TException {
        putAsset_result result = new putAsset_result();
        result.success = iface.putAsset(args.auth, args.req);
        result.setSuccessIsSet(true);
        return result;
      }
    }

  }

  public static class putAsset_args implements org.apache.thrift.TBase<putAsset_args, putAsset_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("putAsset_args");

    private static final org.apache.thrift.protocol.TField AUTH_FIELD_DESC = new org.apache.thrift.protocol.TField("auth", org.apache.thrift.protocol.TType.STRUCT, (short)1);
    private static final org.apache.thrift.protocol.TField REQ_FIELD_DESC = new org.apache.thrift.protocol.TField("req", org.apache.thrift.protocol.TType.STRUCT, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new putAsset_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new putAsset_argsTupleSchemeFactory());
    }

    public com.vng.zing.media.common.thrift.TThriftAuth auth; // required
    public com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      AUTH((short)1, "auth"),
      REQ((short)2, "req");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // AUTH
            return AUTH;
          case 2: // REQ
            return REQ;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.AUTH, new org.apache.thrift.meta_data.FieldMetaData("auth", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.vng.zing.media.common.thrift.TThriftAuth.class)));
      tmpMap.put(_Fields.REQ, new org.apache.thrift.meta_data.FieldMetaData("req", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(putAsset_args.class, metaDataMap);
    }

    public putAsset_args() {
    }

    public putAsset_args(
      com.vng.zing.media.common.thrift.TThriftAuth auth,
      com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req)
    {
      this();
      this.auth = auth;
      this.req = req;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public putAsset_args(putAsset_args other) {
      if (other.isSetAuth()) {
        this.auth = new com.vng.zing.media.common.thrift.TThriftAuth(other.auth);
      }
      if (other.isSetReq()) {
        this.req = new com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq(other.req);
      }
    }

    public putAsset_args deepCopy() {
      return new putAsset_args(this);
    }

    @Override
    public void clear() {
      this.auth = null;
      this.req = null;
    }

    public com.vng.zing.media.common.thrift.TThriftAuth getAuth() {
      return this.auth;
    }

    public putAsset_args setAuth(com.vng.zing.media.common.thrift.TThriftAuth auth) {
      this.auth = auth;
      return this;
    }

    public void unsetAuth() {
      this.auth = null;
    }

    /** Returns true if field auth is set (has been assigned a value) and false otherwise */
    public boolean isSetAuth() {
      return this.auth != null;
    }

    public void setAuthIsSet(boolean value) {
      if (!value) {
        this.auth = null;
      }
    }

    public com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq getReq() {
      return this.req;
    }

    public putAsset_args setReq(com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq req) {
      this.req = req;
      return this;
    }

    public void unsetReq() {
      this.req = null;
    }

    /** Returns true if field req is set (has been assigned a value) and false otherwise */
    public boolean isSetReq() {
      return this.req != null;
    }

    public void setReqIsSet(boolean value) {
      if (!value) {
        this.req = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case AUTH:
        if (value == null) {
          unsetAuth();
        } else {
          setAuth((com.vng.zing.media.common.thrift.TThriftAuth)value);
        }
        break;

      case REQ:
        if (value == null) {
          unsetReq();
        } else {
          setReq((com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case AUTH:
        return getAuth();

      case REQ:
        return getReq();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case AUTH:
        return isSetAuth();
      case REQ:
        return isSetReq();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof putAsset_args)
        return this.equals((putAsset_args)that);
      return false;
    }

    public boolean equals(putAsset_args that) {
      if (that == null)
        return false;

      boolean this_present_auth = true && this.isSetAuth();
      boolean that_present_auth = true && that.isSetAuth();
      if (this_present_auth || that_present_auth) {
        if (!(this_present_auth && that_present_auth))
          return false;
        if (!this.auth.equals(that.auth))
          return false;
      }

      boolean this_present_req = true && this.isSetReq();
      boolean that_present_req = true && that.isSetReq();
      if (this_present_req || that_present_req) {
        if (!(this_present_req && that_present_req))
          return false;
        if (!this.req.equals(that.req))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(putAsset_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      putAsset_args typedOther = (putAsset_args)other;

      lastComparison = Boolean.valueOf(isSetAuth()).compareTo(typedOther.isSetAuth());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetAuth()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.auth, typedOther.auth);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetReq()).compareTo(typedOther.isSetReq());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetReq()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.req, typedOther.req);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("putAsset_args(");
      boolean first = true;

      sb.append("auth:");
      if (this.auth == null) {
        sb.append("null");
      } else {
        sb.append(this.auth);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("req:");
      if (this.req == null) {
        sb.append("null");
      } else {
        sb.append(this.req);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
      if (auth != null) {
        auth.validate();
      }
      if (req != null) {
        req.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class putAsset_argsStandardSchemeFactory implements SchemeFactory {
      public putAsset_argsStandardScheme getScheme() {
        return new putAsset_argsStandardScheme();
      }
    }

    private static class putAsset_argsStandardScheme extends StandardScheme<putAsset_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, putAsset_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // AUTH
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.auth = new com.vng.zing.media.common.thrift.TThriftAuth();
                struct.auth.read(iprot);
                struct.setAuthIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // REQ
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.req = new com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq();
                struct.req.read(iprot);
                struct.setReqIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, putAsset_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.auth != null) {
          oprot.writeFieldBegin(AUTH_FIELD_DESC);
          struct.auth.write(oprot);
          oprot.writeFieldEnd();
        }
        if (struct.req != null) {
          oprot.writeFieldBegin(REQ_FIELD_DESC);
          struct.req.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class putAsset_argsTupleSchemeFactory implements SchemeFactory {
      public putAsset_argsTupleScheme getScheme() {
        return new putAsset_argsTupleScheme();
      }
    }

    private static class putAsset_argsTupleScheme extends TupleScheme<putAsset_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, putAsset_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetAuth()) {
          optionals.set(0);
        }
        if (struct.isSetReq()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetAuth()) {
          struct.auth.write(oprot);
        }
        if (struct.isSetReq()) {
          struct.req.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, putAsset_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.auth = new com.vng.zing.media.common.thrift.TThriftAuth();
          struct.auth.read(iprot);
          struct.setAuthIsSet(true);
        }
        if (incoming.get(1)) {
          struct.req = new com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq();
          struct.req.read(iprot);
          struct.setReqIsSet(true);
        }
      }
    }

  }

  public static class putAsset_result implements org.apache.thrift.TBase<putAsset_result, putAsset_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("putAsset_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.I32, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new putAsset_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new putAsset_resultTupleSchemeFactory());
    }

    public int success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __SUCCESS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(putAsset_result.class, metaDataMap);
    }

    public putAsset_result() {
    }

    public putAsset_result(
      int success)
    {
      this();
      this.success = success;
      setSuccessIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public putAsset_result(putAsset_result other) {
      __isset_bitfield = other.__isset_bitfield;
      this.success = other.success;
    }

    public putAsset_result deepCopy() {
      return new putAsset_result(this);
    }

    @Override
    public void clear() {
      setSuccessIsSet(false);
      this.success = 0;
    }

    public int getSuccess() {
      return this.success;
    }

    public putAsset_result setSuccess(int success) {
      this.success = success;
      setSuccessIsSet(true);
      return this;
    }

    public void unsetSuccess() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return EncodingUtils.testBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    public void setSuccessIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUCCESS_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return Integer.valueOf(getSuccess());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof putAsset_result)
        return this.equals((putAsset_result)that);
      return false;
    }

    public boolean equals(putAsset_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true;
      boolean that_present_success = true;
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (this.success != that.success)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(putAsset_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      putAsset_result typedOther = (putAsset_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("putAsset_result(");
      boolean first = true;

      sb.append("success:");
      sb.append(this.success);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class putAsset_resultStandardSchemeFactory implements SchemeFactory {
      public putAsset_resultStandardScheme getScheme() {
        return new putAsset_resultStandardScheme();
      }
    }

    private static class putAsset_resultStandardScheme extends StandardScheme<putAsset_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, putAsset_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.success = iprot.readI32();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, putAsset_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.isSetSuccess()) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeI32(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class putAsset_resultTupleSchemeFactory implements SchemeFactory {
      public putAsset_resultTupleScheme getScheme() {
        return new putAsset_resultTupleScheme();
      }
    }

    private static class putAsset_resultTupleScheme extends TupleScheme<putAsset_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, putAsset_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeI32(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, putAsset_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readI32();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
