package com.ljzn.grpc.personinfo;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: personinfo/personinfo.service.proto")
public final class PersonInfoAuthServiceGrpc {

  private PersonInfoAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "PrisonSystem.PersonInfoAuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.PersoninfoRequest,
      com.ljzn.grpc.personinfo.PersoninfoResponse> getGetPersonInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPersonInfo",
      requestType = com.ljzn.grpc.personinfo.PersoninfoRequest.class,
      responseType = com.ljzn.grpc.personinfo.PersoninfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.PersoninfoRequest,
      com.ljzn.grpc.personinfo.PersoninfoResponse> getGetPersonInfoMethod() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.PersoninfoRequest, com.ljzn.grpc.personinfo.PersoninfoResponse> getGetPersonInfoMethod;
    if ((getGetPersonInfoMethod = PersonInfoAuthServiceGrpc.getGetPersonInfoMethod) == null) {
      synchronized (PersonInfoAuthServiceGrpc.class) {
        if ((getGetPersonInfoMethod = PersonInfoAuthServiceGrpc.getGetPersonInfoMethod) == null) {
          PersonInfoAuthServiceGrpc.getGetPersonInfoMethod = getGetPersonInfoMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.personinfo.PersoninfoRequest, com.ljzn.grpc.personinfo.PersoninfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrisonSystem.PersonInfoAuthService", "GetPersonInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.personinfo.PersoninfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.personinfo.PersoninfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonInfoAuthServiceMethodDescriptorSupplier("GetPersonInfo"))
                  .build();
          }
        }
     }
     return getGetPersonInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.UploadRecordInfoRequest,
      com.ljzn.grpc.personinfo.UploadRecordInfoResponse> getUploadRecordInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadRecordInfo",
      requestType = com.ljzn.grpc.personinfo.UploadRecordInfoRequest.class,
      responseType = com.ljzn.grpc.personinfo.UploadRecordInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.UploadRecordInfoRequest,
      com.ljzn.grpc.personinfo.UploadRecordInfoResponse> getUploadRecordInfoMethod() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.personinfo.UploadRecordInfoRequest, com.ljzn.grpc.personinfo.UploadRecordInfoResponse> getUploadRecordInfoMethod;
    if ((getUploadRecordInfoMethod = PersonInfoAuthServiceGrpc.getUploadRecordInfoMethod) == null) {
      synchronized (PersonInfoAuthServiceGrpc.class) {
        if ((getUploadRecordInfoMethod = PersonInfoAuthServiceGrpc.getUploadRecordInfoMethod) == null) {
          PersonInfoAuthServiceGrpc.getUploadRecordInfoMethod = getUploadRecordInfoMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.personinfo.UploadRecordInfoRequest, com.ljzn.grpc.personinfo.UploadRecordInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrisonSystem.PersonInfoAuthService", "UploadRecordInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.personinfo.UploadRecordInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.personinfo.UploadRecordInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonInfoAuthServiceMethodDescriptorSupplier("UploadRecordInfo"))
                  .build();
          }
        }
     }
     return getUploadRecordInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonInfoAuthServiceStub newStub(io.grpc.Channel channel) {
    return new PersonInfoAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonInfoAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonInfoAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonInfoAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonInfoAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PersonInfoAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPersonInfo(com.ljzn.grpc.personinfo.PersoninfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.PersoninfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPersonInfoMethod(), responseObserver);
    }

    /**
     */
    public void uploadRecordInfo(com.ljzn.grpc.personinfo.UploadRecordInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.UploadRecordInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUploadRecordInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.personinfo.PersoninfoRequest,
                com.ljzn.grpc.personinfo.PersoninfoResponse>(
                  this, METHODID_GET_PERSON_INFO)))
          .addMethod(
            getUploadRecordInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.personinfo.UploadRecordInfoRequest,
                com.ljzn.grpc.personinfo.UploadRecordInfoResponse>(
                  this, METHODID_UPLOAD_RECORD_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class PersonInfoAuthServiceStub extends io.grpc.stub.AbstractStub<PersonInfoAuthServiceStub> {
    private PersonInfoAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonInfoAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonInfoAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonInfoAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPersonInfo(com.ljzn.grpc.personinfo.PersoninfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.PersoninfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPersonInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void uploadRecordInfo(com.ljzn.grpc.personinfo.UploadRecordInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.UploadRecordInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUploadRecordInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PersonInfoAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonInfoAuthServiceBlockingStub> {
    private PersonInfoAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonInfoAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonInfoAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonInfoAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.personinfo.PersoninfoResponse getPersonInfo(com.ljzn.grpc.personinfo.PersoninfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPersonInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.personinfo.UploadRecordInfoResponse uploadRecordInfo(com.ljzn.grpc.personinfo.UploadRecordInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getUploadRecordInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonInfoAuthServiceFutureStub extends io.grpc.stub.AbstractStub<PersonInfoAuthServiceFutureStub> {
    private PersonInfoAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonInfoAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonInfoAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonInfoAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.personinfo.PersoninfoResponse> getPersonInfo(
        com.ljzn.grpc.personinfo.PersoninfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPersonInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.personinfo.UploadRecordInfoResponse> uploadRecordInfo(
        com.ljzn.grpc.personinfo.UploadRecordInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUploadRecordInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON_INFO = 0;
  private static final int METHODID_UPLOAD_RECORD_INFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonInfoAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonInfoAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON_INFO:
          serviceImpl.getPersonInfo((com.ljzn.grpc.personinfo.PersoninfoRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.PersoninfoResponse>) responseObserver);
          break;
        case METHODID_UPLOAD_RECORD_INFO:
          serviceImpl.uploadRecordInfo((com.ljzn.grpc.personinfo.UploadRecordInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.personinfo.UploadRecordInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonInfoAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonInfoAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.personinfo.PersoninfoService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonInfoAuthService");
    }
  }

  private static final class PersonInfoAuthServiceFileDescriptorSupplier
      extends PersonInfoAuthServiceBaseDescriptorSupplier {
    PersonInfoAuthServiceFileDescriptorSupplier() {}
  }

  private static final class PersonInfoAuthServiceMethodDescriptorSupplier
      extends PersonInfoAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonInfoAuthServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonInfoAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonInfoAuthServiceFileDescriptorSupplier())
              .addMethod(getGetPersonInfoMethod())
              .addMethod(getUploadRecordInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
