package services;

import helloworld.Protobuf;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.logging.Logger;

@GrpcService
public class GrpcServerService extends helloworld.GreeterGrpc.GreeterImplBase {
    private static final Logger logger = Logger.getLogger(GrpcServerService.class.getName());
    @Override
    public void sayHello(Protobuf.HelloRequest req, StreamObserver<Protobuf.HelloReply> responseObserver) {
        logger.info("Got request from client: " + req);
        Protobuf.HelloReply reply = Protobuf.HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}