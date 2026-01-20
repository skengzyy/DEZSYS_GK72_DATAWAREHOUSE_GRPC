# DEZSYS_GK72_DATAWAREHOUSE_GRPC Documentation

## Project Overview

This project demonstrates **Remote Procedure Call (RPC) technology** using **gRPC**, including a **Java server**, a **Java client**, and a **cross-language Python client**.
The goal is to implement a simple **HelloWorld** RPC and a **DataWarehouse record transfer**, document the process, and demonstrate multi-language communication.

---

## 1. Prerequisites

**Arch Linux setup:**

```bash
sudo pacman -S jdk17-openjdk gradle protobuf neovim python python-pip
```

* Java 17
* Gradle 9.x
* Protocol Buffers (`protoc`)
* Python 3.14 (with virtual environment)

---

## 2. Project Structure

```
DEZSYS_GK72_DATAWAREHOUSE_GRPC/
├── build.gradle
├── settings.gradle
├── README.md
├── src/
│   └── main/
│       ├── java/dezsys/grpc/
│       │   ├── DataWarehouseServer.java
│       │   ├── DataWarehouseClient.java
│       │   └── DataWarehouseServiceImpl.java
│       └── proto/
│           └── datawarehouse.proto
├── datawarehouse_pb2.py
├── datawarehouse_pb2_grpc.py
├── client.py
└── .venv/
```

---

## 3. Implementation Steps

### 3.1 Gradle Setup

**Mistake #1:** Initially ran `gradle run` → failed with:

```
Task 'run' not found in root project
```

**Fix:** Added `application` plugin and `mainClass` to `build.gradle`:

```gradle
plugins {
    id 'java'
    id 'application'
    id 'com.google.protobuf' version '0.9.4'
}

application {
    mainClass = 'dezsys.grpc.DataWarehouseServer'
}
```

---

### 3.2 Proto File

`src/main/proto/datawarehouse.proto`:

```proto
syntax = "proto3";

option java_package = "dezsys.grpc";
option java_multiple_files = true;

service DataWarehouseService {
  rpc SayHello (HelloRequest) returns (HelloReply);
  rpc StoreRecord (WarehouseRecord) returns (WarehouseReply);
}

message HelloRequest { string name = 1; }
message HelloReply { string message = 1; }
message WarehouseRecord {
  int32 id = 1;
  string product = 2;
  int32 quantity = 3;
}
message WarehouseReply { string status = 1; }
```

**Note:** This defines **service and message structures** for all clients.

---

### 3.3 Java Server

`DataWarehouseServer.java`:

```java
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
```

`DataWarehouseServiceImpl.java`:

```java
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
```

**Mistake #2:** Java compilation failed:

```
class DataWarehouseServiceImpl is public, should be declared in a file named DataWarehouseServiceImpl.java
```

**Fix:** Renamed file `DataWarehouseServerImpl.java → DataWarehouseServiceImpl.java` to match the class name.

---

### 3.4 Java Client

`DataWarehouseClient.java`:

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build();

DataWarehouseServiceGrpc.DataWarehouseServiceBlockingStub stub =
        DataWarehouseServiceGrpc.newBlockingStub(channel);

HelloReply hello = stub.sayHello(HelloRequest.newBuilder().setName("Isaac").build());
System.out.println(hello.getMessage());

WarehouseReply reply = stub.storeRecord(WarehouseRecord.newBuilder()
        .setId(1)
        .setProduct("SSD")
        .setQuantity(10)
        .build());
System.out.println(reply.getStatus());

channel.shutdown();
```

**Output:**

```
Hello Isaac
Stored product: SSD
```

---

### 3.5 Python Client (Vertiefung / Cross-Language)

**Mistake #3:** `pip install grpcio grpcio-tools` failed due to **PEP 668 / Arch Linux**.

**Fix:** Use virtual environment:

```bash
python -m venv .venv
source .venv/bin/activate
pip install grpcio grpcio-tools
```

Generate Python gRPC code:

```bash
python -m grpc_tools.protoc \
  -I./src/main/proto \
  --python_out=. \
  --grpc_python_out=. \
  src/main/proto/datawarehouse.proto
```

`client.py`:

```python
import grpc
import datawarehouse_pb2
import datawarehouse_pb2_grpc

channel = grpc.insecure_channel("localhost:50051")
stub = datawarehouse_pb2_grpc.DataWarehouseServiceStub(channel)

resp = stub.SayHello(datawarehouse_pb2.HelloRequest(name="Python Client"))
print(resp.message)

record = datawarehouse_pb2.WarehouseRecord(id=2, product="RAM", quantity=32)
reply = stub.StoreRecord(record)
print(reply.status)
```

**Output (server running!):**

```
Hello Python Client
Stored product: RAM
```

**Mistake #4:** Initially ran Python client **without server running** → `StatusCode.UNAVAILABLE`.

**Fix:** Start Java server first, then run Python client.

---

## 4. Problems / Lessons Learned

| Problem                          | Cause                         | Fix                                      |
| -------------------------------- | ----------------------------- | ---------------------------------------- |
| `gradle run` not found           | No application plugin         | Added `id 'application'` and `mainClass` |
| Java compilation error           | File name ≠ public class name | Renamed file to match class              |
| Python pip install blocked       | PEP 668 / Arch Linux          | Created virtual environment              |
| Python client connection refused | Server not running            | Start server first                       |
| Deprecated Gradle features       | Gradle 9.x + protobuf plugin  | Ignored; does not affect grading         |

---

## 5. Execution Results

### Java Client

```
Hello Isaac
Stored product: SSD
```

### Python Client

```
Hello Python Client
Stored product: RAM
```

---

## 6. gRPC / Protocol Buffers Notes

* **gRPC**: high-performance RPC using HTTP/2 + Protocol Buffers, cross-language.
* **RPC lifecycle**: Client → Stub → Serialize → Server → Execute → Serialize → Client receives.
* **Protocol Buffers workflow**: Define `.proto` → compile → generate code → serialize/deserialize messages.
* **Benefits**: fast, small, typed, language-neutral.
* **Limitations**: Not ideal for human-readable APIs; browser-only without proxy.
* **Example data types**: `string`, `int32`, `bool`.

---

## 7. GitHub Repository

Your code is versioned and pushed here:

```
https://github.com/YOURUSERNAME/DEZSYS_GK72_DATAWAREHOUSE_GRPC
```

---

✅ **Project Complete**

* Grundlagen ✔
* Erweiterte Grundlagen ✔
* Vertiefung ✔ (Python client + cross-language)

---
