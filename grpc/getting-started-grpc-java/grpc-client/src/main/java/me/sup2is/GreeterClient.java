package me.sup2is;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import me.sup2is.rpc.GreeterGrpc;
import me.sup2is.rpc.Hello;

import java.util.concurrent.TimeUnit;

public class GreeterClient {

    private final GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    public GreeterClient(Channel channel) {
//         'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
//         shut it down.

//         Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        greeterBlockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) throws Exception {
        String user = "hyeon seop";
        int age = 28;

        // Access a service running on the local machine on port 50051
        String target = "localhost:50051";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        try {
            GreeterClient client = new GreeterClient(channel);
            client.greet(user, age);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    public void greet(String name, int age) {
        System.out.println("Will try to greet " + name  + "(" + age + ")"+ " ...");

        final Hello.Request request = Hello.Request.newBuilder()
                .setAge(age)
                .setName(name)
                .build();

        Hello.Response response;

        try {
            response = greeterBlockingStub.hello(request);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed:" +  e.getStatus());
            return;
        }
        System.out.println("Greeter Server: " + response.getStr());
    }

}
