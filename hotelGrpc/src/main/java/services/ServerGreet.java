package services;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ServerGreet {
    private static final Logger logger = Logger.getLogger(ServerGreet.class.getName());
    private Server server;
    private void start() throws IOException {
        int port = 9000;
        server = ServerBuilder.forPort(port).addService(new GrpcServerService()).build().start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server");
                try { server.shutdown().awaitTermination(30, TimeUnit.SECONDS);}
                catch (InterruptedException e) { e.printStackTrace(System.err);}
            }
        });
    }
}
