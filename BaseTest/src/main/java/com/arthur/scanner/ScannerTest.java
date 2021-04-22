package com.arthur.scanner;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //Scanner.nextInt()之后如果使用nextLine(),则会接收不到字符串
        Scanner cin=new Scanner(System.in);
        while(cin.hasNextInt()){
            int n=cin.nextInt();
//          第一种方法是在nextInt之后，nextLine之前，先把空格读掉
            cin.nextLine();
            while(n != 0) {
                cin.nextLine();
                n--;
            }
//            第二种方法是全部用nextLine
            Integer.parseInt(cin.nextLine());
            //Start coding -- Input Data
        }
    }
}
