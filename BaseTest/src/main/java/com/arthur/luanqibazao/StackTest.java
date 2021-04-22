package com.arthur.luanqibazao;

import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> stack = new LinkedList<>();
        while(n != 0) {
            int sh = n % 16;
            n = n / 16;
            stack.push(Integer.toHexString(sh));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

