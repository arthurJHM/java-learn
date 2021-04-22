package com.arthur.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @title: NioTest
 * @Author ArthurJi
 * @Date: 2021/3/20 15:52
 * @Version 1.0
 */
public class filechannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("src/main/java/com/arthur/nio/file.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int readbyte = channel.read(buf);
        System.out.println(readbyte);
        while (readbyte != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
            readbyte = channel.read(buf);
        }

        String newData = "weflkwenflnlvnslknv" + System.currentTimeMillis();
        buf.clear();
        buf.put(newData.getBytes(StandardCharsets.UTF_8));
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }
        channel.close();
        file.close();
    }
}
