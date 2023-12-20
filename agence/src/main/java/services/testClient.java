package services;

import helloworld.GreeterGrpc;
import helloworld.Protobuf;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class testClient {

    private static final String HOST = "localhost";
    private static final int PORT = 9001;

    public String sayHello(String name) {
        ManagedChannel channel = null;
        try {
            // Create a communication channel to the server
            channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                    .usePlaintext()
                    .build();

            // Create a blocking stub
            GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

            // Prepare the request
            Protobuf.HelloRequest request = Protobuf.HelloRequest.newBuilder().setName(name).build();

            // Make the RPC call
            Protobuf.HelloReply response = stub.sayHello(request);

            // Return the response
            return response.getMessage();
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        } finally {
            // Clean up: shutdown the channel
            if (channel != null) {
                channel.shutdown();
            }
        }
    }
}
