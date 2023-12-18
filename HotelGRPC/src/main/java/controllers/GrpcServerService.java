package controllers;

import helloworld.Protobuf;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService {

    public void sayHello(Protobuf.HelloRequest req, StreamObserver<Protobuf.HelloReply> responseObserver) {
        Protobuf.HelloReply reply = Protobuf.HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
