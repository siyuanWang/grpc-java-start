package com.wsy.grpc.start.server;

import com.demo.Rank;
import com.demo.RankerGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RankService extends RankerGrpc.RankerImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RankService.class);

    @Override
    public void rank(Rank.RankRequest request, StreamObserver<Rank.RankReply> responseObserver) {
        LOGGER.info("getIpByName入参为:{}", request.getMdd());

        Rank.RankReply reply = Rank.RankReply.newBuilder().setSortedids("1,2,3").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
