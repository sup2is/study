package me.sup2is;

import io.grpc.stub.StreamObserver;
import me.sup2is.rpc.GreeterGrpc;
import me.sup2is.rpc.Hello;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void hello(final Hello.Request request, final StreamObserver<Hello.Response> responseObserver) {

        final String str = "Hello " + request.getName() + "(" + request.getAge() + ")";
        System.out.println(str);

        final Hello.Response response = Hello.Response.newBuilder()
                .setStr(str)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
