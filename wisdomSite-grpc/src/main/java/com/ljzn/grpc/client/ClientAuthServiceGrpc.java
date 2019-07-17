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
    comments = "Source: client/client.service.proto")
public final class ClientAuthServiceGrpc {

  private ClientAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "PrisonSystem.ClientAuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.ljzn.grpc.client.LoginRequest.class,
      responseType = com.ljzn.grpc.client.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest, com.ljzn.grpc.client.LoginResponse> getLoginMethod;
    if ((getLoginMethod = ClientAuthServiceGrpc.getLoginMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getLoginMethod = ClientAuthServiceGrpc.getLoginMethod) == null) {
          ClientAuthServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.LoginRequest, com.ljzn.grpc.client.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrisonSystem.ClientAuthService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartBeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HeartBeat",
      requestType = com.ljzn.grpc.client.HeartbeatRequest.class,
      responseType = com.ljzn.grpc.client.HeartbeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartBeatMethod() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse> getHeartBeatMethod;
    if ((getHeartBeatMethod = ClientAuthServiceGrpc.getHeartBeatMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getHeartBeatMethod = ClientAuthServiceGrpc.getHeartBeatMethod) == null) {
          ClientAuthServiceGrpc.getHeartBeatMethod = getHeartBeatMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrisonSystem.ClientAuthService", "HeartBeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("HeartBeat"))
                  .build();
          }
        }
     }
     return getHeartBeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientAuthServiceStub newStub(io.grpc.Channel channel) {
    return new ClientAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.ljzn.grpc.client.LoginRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void heartBeat(com.ljzn.grpc.client.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHeartBeatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.LoginRequest,
                com.ljzn.grpc.client.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getHeartBeatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.HeartbeatRequest,
                com.ljzn.grpc.client.HeartbeatResponse>(
                  this, METHODID_HEART_BEAT)))
          .build();
    }
  }

  /**
   */
  public static final class ClientAuthServiceStub extends io.grpc.stub.AbstractStub<ClientAuthServiceStub> {
    private ClientAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.ljzn.grpc.client.LoginRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void heartBeat(com.ljzn.grpc.client.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHeartBeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientAuthServiceBlockingStub> {
    private ClientAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.client.LoginResponse login(com.ljzn.grpc.client.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.client.HeartbeatResponse heartBeat(com.ljzn.grpc.client.HeartbeatRequest request) {
      return blockingUnaryCall(
          getChannel(), getHeartBeatMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientAuthServiceFutureStub extends io.grpc.stub.AbstractStub<ClientAuthServiceFutureStub> {
    private ClientAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.LoginResponse> login(
        com.ljzn.grpc.client.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.HeartbeatResponse> heartBeat(
        com.ljzn.grpc.client.HeartbeatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHeartBeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_HEART_BEAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.ljzn.grpc.client.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse>) responseObserver);
          break;
        case METHODID_HEART_BEAT:
          serviceImpl.heartBeat((com.ljzn.grpc.client.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse>) responseObserver);
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

  private static abstract class ClientAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.client.ClientService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientAuthService");
    }
  }

  private static final class ClientAuthServiceFileDescriptorSupplier
      extends ClientAuthServiceBaseDescriptorSupplier {
    ClientAuthServiceFileDescriptorSupplier() {}
  }

  private static final class ClientAuthServiceMethodDescriptorSupplier
      extends ClientAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientAuthServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getHeartBeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
