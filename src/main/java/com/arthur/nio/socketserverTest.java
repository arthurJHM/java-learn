package com.arthur.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @title: socketserverTest
 * @Author ArthurJi
 * @Date: 2021/3/20 16:18
 * @Version 1.0
 */
public class socketserverTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ch = ServerSocketChannel.open();
        ch.socket().bind(new InetSocketAddress(1088));
        while (true) {
            SocketChannel socketChannel = ch.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int read = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }

        }
    }
}
