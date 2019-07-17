package com.ljzn.grpc.client;

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
    comments = "Source: client/verify.service.proto")
public final class VerifyServiceGrpc {

  private VerifyServiceGrpc() {}

  public static final String SERVICE_NAME = "ClientVerify.VerifyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.VerifyRequest,
      com.ljzn.grpc.client.VerifyResponse> getVerifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Verify",
      requestType = com.ljzn.grpc.client.VerifyRequest.class,
      responseType = com.ljzn.grpc.client.VerifyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.VerifyRequest,
      com.ljzn.grpc.client.VerifyResponse> getVerifyMethod() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.VerifyRequest, com.ljzn.grpc.client.VerifyResponse> getVerifyMethod;
    if ((getVerifyMethod = VerifyServiceGrpc.getVerifyMethod) == null) {
      synchronized (VerifyServiceGrpc.class) {
        if ((getVerifyMethod = VerifyServiceGrpc.getVerifyMethod) == null) {
          VerifyServiceGrpc.getVerifyMethod = getVerifyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.VerifyRequest, com.ljzn.grpc.client.VerifyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientVerify.VerifyService", "Verify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.VerifyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.VerifyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VerifyServiceMethodDescriptorSupplier("Verify"))
                  .build();
          }
        }
     }
     return getVerifyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VerifyServiceStub newStub(io.grpc.Channel channel) {
    return new VerifyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VerifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VerifyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VerifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VerifyServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VerifyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void verify(com.ljzn.grpc.client.VerifyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.VerifyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerifyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.VerifyRequest,
                com.ljzn.grpc.client.VerifyResponse>(
                  this, METHODID_VERIFY)))
          .build();
    }
  }

  /**
   */
  public static final class VerifyServiceStub extends io.grpc.stub.AbstractStub<VerifyServiceStub> {
    private VerifyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerifyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerifyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerifyServiceStub(channel, callOptions);
    }

    /**
     */
    public void verify(com.ljzn.grpc.client.VerifyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.VerifyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VerifyServiceBlockingStub extends io.grpc.stub.AbstractStub<VerifyServiceBlockingStub> {
    private VerifyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerifyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerifyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerifyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.client.VerifyResponse verify(com.ljzn.grpc.client.VerifyRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerifyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VerifyServiceFutureStub extends io.grpc.stub.AbstractStub<VerifyServiceFutureStub> {
    private VerifyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerifyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerifyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerifyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.VerifyResponse> verify(
        com.ljzn.grpc.client.VerifyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VerifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VerifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFY:
          serviceImpl.verify((com.ljzn.grpc.client.VerifyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.VerifyResponse>) responseObserver);
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

  private static abstract class VerifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VerifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.client.VerifyServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VerifyService");
    }
  }

  private static final class VerifyServiceFileDescriptorSupplier
      extends VerifyServiceBaseDescriptorSupplier {
    VerifyServiceFileDescriptorSupplier() {}
  }

  private static final class VerifyServiceMethodDescriptorSupplier
      extends VerifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VerifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VerifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VerifyServiceFileDescriptorSupplier())
              .addMethod(getVerifyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
