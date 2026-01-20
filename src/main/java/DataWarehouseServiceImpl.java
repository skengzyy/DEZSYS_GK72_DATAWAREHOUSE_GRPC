package dezsys.grpc;

import io.grpc.stub.StreamObserver;

public class DataWarehouseServiceImpl extends DataWarehouseServiceGrpc.DataWarehouseServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void storeRecord(WarehouseRecord request, StreamObserver<WarehouseReply> responseObserver) {
        WarehouseReply reply = WarehouseReply.newBuilder()
                .setStatus("Stored product: " + request.getProduct())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

