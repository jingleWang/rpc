package com.jingl.rpc.exchanger.netty;

import com.jingl.rpc.handle.Invoker;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.net.InetSocketAddress;

/**
 * Created by Ben on 26/03/2018.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = Logger.getLogger(NettyClientHandler.class);
    private Invoker invoker;

    public NettyClientHandler(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress local = (InetSocketAddress) ctx.channel().localAddress();
        InetSocketAddress remote = (InetSocketAddress) ctx.channel().remoteAddress();

        logger.info("local address: " + local.getHostString() + " connect to remote address: " + remote.getHostString() + " at port: " + remote.getPort());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        int length = buf.readableBytes();
        byte[] rep = new byte[length];
        buf.readBytes(rep);
        buf.release();
        invoker.invoke(rep);
    }
}
