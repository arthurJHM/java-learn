package com.arthur.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @title: socketchannel
 * @Author ArthurJi
 * @Date: 2021/3/20 16:13
 * @Version 1.0
 */
public class socketchannelTest {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1088));
        ByteBuffer buf = ByteBuffer.allocate(48);
//        int read = channel.read(buf);
        String str = "ceshiceshicehishiSocketChannel";
        buf.put(str.getBytes(StandardCharsets.UTF_8));
        buf.flip();
        channel.write(buf);
        channel.close();
    }
}
