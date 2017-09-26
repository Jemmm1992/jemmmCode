package com.rpc;

import java.net.InetSocketAddress;

/**
 * Created by BIG-JIAN on 2017/9/8.
 */
public class PRCTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RPCExporter.exporter("localhost", 8088);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        RPCImporter<EchoService> importer = new RPCImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Are you ok ?"));
    }
}
