package com.rpc;

/**
 * Created by BIG-JIAN on 2017/9/8.
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }
}
