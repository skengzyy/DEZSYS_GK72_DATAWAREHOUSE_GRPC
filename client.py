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
