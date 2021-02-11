package grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: assign3.proto")
public final class PillboxServiceGrpc {

  private PillboxServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.PillboxService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.MedicationPlanRequest,
      grpc.MedicationPlanResponse> METHOD_GET_MEDICATION_PLANS =
      io.grpc.MethodDescriptor.<grpc.MedicationPlanRequest, grpc.MedicationPlanResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PillboxService", "getMedicationPlans"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.MedicationPlanRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.MedicationPlanResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.GRPCMedicationAction,
      grpc.EmptyResponse> METHOD_SEND_PATIENT_ACTION =
      io.grpc.MethodDescriptor.<grpc.GRPCMedicationAction, grpc.EmptyResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PillboxService", "sendPatientAction"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.GRPCMedicationAction.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.EmptyResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PillboxServiceStub newStub(io.grpc.Channel channel) {
    return new PillboxServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PillboxServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PillboxServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PillboxServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PillboxServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PillboxServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMedicationPlans(grpc.MedicationPlanRequest request,
        io.grpc.stub.StreamObserver<grpc.MedicationPlanResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MEDICATION_PLANS, responseObserver);
    }

    /**
     */
    public void sendPatientAction(grpc.GRPCMedicationAction request,
        io.grpc.stub.StreamObserver<grpc.EmptyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_PATIENT_ACTION, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_MEDICATION_PLANS,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.MedicationPlanRequest,
                grpc.MedicationPlanResponse>(
                  this, METHODID_GET_MEDICATION_PLANS)))
          .addMethod(
            METHOD_SEND_PATIENT_ACTION,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.GRPCMedicationAction,
                grpc.EmptyResponse>(
                  this, METHODID_SEND_PATIENT_ACTION)))
          .build();
    }
  }

  /**
   */
  public static final class PillboxServiceStub extends io.grpc.stub.AbstractStub<PillboxServiceStub> {
    private PillboxServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PillboxServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PillboxServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PillboxServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMedicationPlans(grpc.MedicationPlanRequest request,
        io.grpc.stub.StreamObserver<grpc.MedicationPlanResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MEDICATION_PLANS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendPatientAction(grpc.GRPCMedicationAction request,
        io.grpc.stub.StreamObserver<grpc.EmptyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_PATIENT_ACTION, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PillboxServiceBlockingStub extends io.grpc.stub.AbstractStub<PillboxServiceBlockingStub> {
    private PillboxServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PillboxServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PillboxServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PillboxServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.MedicationPlanResponse getMedicationPlans(grpc.MedicationPlanRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MEDICATION_PLANS, getCallOptions(), request);
    }

    /**
     */
    public grpc.EmptyResponse sendPatientAction(grpc.GRPCMedicationAction request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_PATIENT_ACTION, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PillboxServiceFutureStub extends io.grpc.stub.AbstractStub<PillboxServiceFutureStub> {
    private PillboxServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PillboxServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PillboxServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PillboxServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.MedicationPlanResponse> getMedicationPlans(
        grpc.MedicationPlanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MEDICATION_PLANS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.EmptyResponse> sendPatientAction(
        grpc.GRPCMedicationAction request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_PATIENT_ACTION, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MEDICATION_PLANS = 0;
  private static final int METHODID_SEND_PATIENT_ACTION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PillboxServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PillboxServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MEDICATION_PLANS:
          serviceImpl.getMedicationPlans((grpc.MedicationPlanRequest) request,
              (io.grpc.stub.StreamObserver<grpc.MedicationPlanResponse>) responseObserver);
          break;
        case METHODID_SEND_PATIENT_ACTION:
          serviceImpl.sendPatientAction((grpc.GRPCMedicationAction) request,
              (io.grpc.stub.StreamObserver<grpc.EmptyResponse>) responseObserver);
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

  private static final class PillboxServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Assign3.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PillboxServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PillboxServiceDescriptorSupplier())
              .addMethod(METHOD_GET_MEDICATION_PLANS)
              .addMethod(METHOD_SEND_PATIENT_ACTION)
              .build();
        }
      }
    }
    return result;
  }
}
