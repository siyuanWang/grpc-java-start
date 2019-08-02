package com.wsy.grpc.start.server;//package com.mfw.search.rank.client;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RpcServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);

    private static final int DEFAULT_PORT = 8080;

    private int port;//服务端口号

    private Server server;

    public RpcServer(int port) {
        this(port, ServerBuilder.forPort(port));
    }

    public RpcServer(int port, ServerBuilder<?> serverBuilder) {

        this.port = port;

        server = serverBuilder.addService(new NameService()).addService(new RankService()).build();

    }

    void start() throws IOException {
        server.start();
        LOGGER.info("Server has started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                RpcServer.this.stop();

            }
        });
    }

    void stop() {

        if (server != null)
            server.shutdown();

    }

    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
