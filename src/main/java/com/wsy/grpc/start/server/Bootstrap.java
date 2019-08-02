package com.wsy.grpc.start.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搜索Rank 服务入口
 */
@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer(8080);
        try {
            rpcServer.start();
            rpcServer.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(Bootstrap.class, args);
    }
}
