package dezsys.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class DataWarehouseServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new DataWarehouseServiceImpl())
                .build();

        server.start();
        System.out.println("gRPC Server started on port 50051");
        server.awaitTermination();
    }
}

