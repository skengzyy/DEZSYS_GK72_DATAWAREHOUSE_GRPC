package dezsys.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DataWarehouseClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        DataWarehouseServiceGrpc.DataWarehouseServiceBlockingStub stub =
                DataWarehouseServiceGrpc.newBlockingStub(channel);

        HelloReply hello = stub.sayHello(
                HelloRequest.newBuilder().setName("Isaac").build()
        );
        System.out.println(hello.getMessage());

        WarehouseReply reply = stub.storeRecord(
                WarehouseRecord.newBuilder()
                        .setId(1)
                        .setProduct("SSD")
                        .setQuantity(10)
                        .build()
        );

        System.out.println(reply.getStatus());
        channel.shutdown();
    }
}

