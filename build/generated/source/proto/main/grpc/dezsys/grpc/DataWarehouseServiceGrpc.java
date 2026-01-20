package dezsys.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: datawarehouse.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataWarehouseServiceGrpc {

  private DataWarehouseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "DataWarehouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dezsys.grpc.HelloRequest,
      dezsys.grpc.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = dezsys.grpc.HelloRequest.class,
      responseType = dezsys.grpc.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dezsys.grpc.HelloRequest,
      dezsys.grpc.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<dezsys.grpc.HelloRequest, dezsys.grpc.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = DataWarehouseServiceGrpc.getSayHelloMethod) == null) {
      synchronized (DataWarehouseServiceGrpc.class) {
        if ((getSayHelloMethod = DataWarehouseServiceGrpc.getSayHelloMethod) == null) {
          DataWarehouseServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<dezsys.grpc.HelloRequest, dezsys.grpc.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dezsys.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dezsys.grpc.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new DataWarehouseServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dezsys.grpc.WarehouseRecord,
      dezsys.grpc.WarehouseReply> getStoreRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StoreRecord",
      requestType = dezsys.grpc.WarehouseRecord.class,
      responseType = dezsys.grpc.WarehouseReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dezsys.grpc.WarehouseRecord,
      dezsys.grpc.WarehouseReply> getStoreRecordMethod() {
    io.grpc.MethodDescriptor<dezsys.grpc.WarehouseRecord, dezsys.grpc.WarehouseReply> getStoreRecordMethod;
    if ((getStoreRecordMethod = DataWarehouseServiceGrpc.getStoreRecordMethod) == null) {
      synchronized (DataWarehouseServiceGrpc.class) {
        if ((getStoreRecordMethod = DataWarehouseServiceGrpc.getStoreRecordMethod) == null) {
          DataWarehouseServiceGrpc.getStoreRecordMethod = getStoreRecordMethod =
              io.grpc.MethodDescriptor.<dezsys.grpc.WarehouseRecord, dezsys.grpc.WarehouseReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StoreRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dezsys.grpc.WarehouseRecord.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dezsys.grpc.WarehouseReply.getDefaultInstance()))
              .setSchemaDescriptor(new DataWarehouseServiceMethodDescriptorSupplier("StoreRecord"))
              .build();
        }
      }
    }
    return getStoreRecordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataWarehouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceStub>() {
        @java.lang.Override
        public DataWarehouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataWarehouseServiceStub(channel, callOptions);
        }
      };
    return DataWarehouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataWarehouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceBlockingStub>() {
        @java.lang.Override
        public DataWarehouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataWarehouseServiceBlockingStub(channel, callOptions);
        }
      };
    return DataWarehouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataWarehouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataWarehouseServiceFutureStub>() {
        @java.lang.Override
        public DataWarehouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataWarehouseServiceFutureStub(channel, callOptions);
        }
      };
    return DataWarehouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sayHello(dezsys.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<dezsys.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    default void storeRecord(dezsys.grpc.WarehouseRecord request,
        io.grpc.stub.StreamObserver<dezsys.grpc.WarehouseReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStoreRecordMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataWarehouseService.
   */
  public static abstract class DataWarehouseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DataWarehouseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataWarehouseService.
   */
  public static final class DataWarehouseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataWarehouseServiceStub> {
    private DataWarehouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataWarehouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataWarehouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(dezsys.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<dezsys.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storeRecord(dezsys.grpc.WarehouseRecord request,
        io.grpc.stub.StreamObserver<dezsys.grpc.WarehouseReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStoreRecordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataWarehouseService.
   */
  public static final class DataWarehouseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataWarehouseServiceBlockingStub> {
    private DataWarehouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataWarehouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataWarehouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dezsys.grpc.HelloReply sayHello(dezsys.grpc.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public dezsys.grpc.WarehouseReply storeRecord(dezsys.grpc.WarehouseRecord request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStoreRecordMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataWarehouseService.
   */
  public static final class DataWarehouseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataWarehouseServiceFutureStub> {
    private DataWarehouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataWarehouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataWarehouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dezsys.grpc.HelloReply> sayHello(
        dezsys.grpc.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dezsys.grpc.WarehouseReply> storeRecord(
        dezsys.grpc.WarehouseRecord request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStoreRecordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_STORE_RECORD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((dezsys.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<dezsys.grpc.HelloReply>) responseObserver);
          break;
        case METHODID_STORE_RECORD:
          serviceImpl.storeRecord((dezsys.grpc.WarehouseRecord) request,
              (io.grpc.stub.StreamObserver<dezsys.grpc.WarehouseReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dezsys.grpc.HelloRequest,
              dezsys.grpc.HelloReply>(
                service, METHODID_SAY_HELLO)))
        .addMethod(
          getStoreRecordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dezsys.grpc.WarehouseRecord,
              dezsys.grpc.WarehouseReply>(
                service, METHODID_STORE_RECORD)))
        .build();
  }

  private static abstract class DataWarehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataWarehouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dezsys.grpc.Datawarehouse.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataWarehouseService");
    }
  }

  private static final class DataWarehouseServiceFileDescriptorSupplier
      extends DataWarehouseServiceBaseDescriptorSupplier {
    DataWarehouseServiceFileDescriptorSupplier() {}
  }

  private static final class DataWarehouseServiceMethodDescriptorSupplier
      extends DataWarehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataWarehouseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataWarehouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataWarehouseServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getStoreRecordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
