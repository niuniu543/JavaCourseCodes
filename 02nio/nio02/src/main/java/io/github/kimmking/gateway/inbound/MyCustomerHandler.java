package io.github.kimmking.gateway.inbound;



import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class MyCustomerHandler extends ChannelInboundHandlerAdapter {

    public MyCustomerHandler(){
        System.out.println("自定义的拦截器");
        System.setProperty("proxyService","http://localhost:8801,http://localhost:8802,http://localhost:8803");
    }

    @Override
    public void channelActive(ChannelHandlerContext cxt){
        System.out.println("自定义的拦截器");
        cxt.fireChannelActive();
    }


}
