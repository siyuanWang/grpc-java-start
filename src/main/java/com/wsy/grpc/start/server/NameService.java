package com.wsy.grpc.start.server;

import io.grpc.examples.nameserver.Ip;
import io.grpc.examples.nameserver.Name;
import io.grpc.examples.nameserver.NameServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameService extends NameServiceGrpc.NameServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameService.class);
    @Override
    public void getIpByName(Name request, StreamObserver<Ip> responseObserver) {
        LOGGER.info("getIpByName入参为:{}", request.getName());
//
        Ip ip = Ip.newBuilder().setIp("127.0.0.1").build();
        responseObserver.onNext(ip);
        responseObserver.onCompleted();
    }
}
