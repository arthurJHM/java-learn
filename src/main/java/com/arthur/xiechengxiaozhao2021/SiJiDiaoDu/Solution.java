package com.arthur.xiechengxiaozhao2021.SiJiDiaoDu;

import java.time.Duration;
import java.time.Instant;

//int[一共n][n/2][n/2] a
//for(i = 0; i < n; i++) {
// a[i][j][k] = max(a[i - 1][j - 1][k], a[i - 1][j][k - 1]);
//}
//求a[n][2/n][n/2]
class Solution{
    static int[][] dp;
    static int[][][] dp3;
    static int half;
    static int ans;
    static int ans1;
    static int ans3;
    static int n;
    static int[][] intput = new int[][]{
            {10, 30},
            {100, 200},
            {150, 50},
            {60, 20},
            {10, 10},
            {10, 10},
//            {150, 50},
//            {60, 20},
//            {10, 30},
//            {100, 200},
//            {150, 50},
//            {60, 20},
//            {150, 50},
//            {60, 20},
//            {10, 30},
//            {100, 200},
//            {150, 50},
//            {60, 20},
//            {150, 50},
//            {60, 20},
//            {10, 30},
//            {100, 200},
//            {150, 50},
//            {6, 22},
//            {60, 20},
//            {10, 30},
//            {100, 200},
//            {150, 50},
//            {60, 20},
//            {1, 3}
    };
    public static void main(String[] args){
//        Scanner cin=new Scanner(System.in);
//        while(cin.hasNextInt()){
//        int incomeOfA=cin.nextInt();
//        int incomeOfB=cin.nextInt();
//
//        //Start coding -- Input Data
//        }

//        System.out.println(intput.length);
        n = intput.length;
        half = n / 2;
        dp = new int[n][n];
        dp3 = new int[half + 2][half + 2][n + 1];


        Instant start = Instant.now();
        dfs(0, 0, 0, 0);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");


        start = Instant.now();
        ans = dp(0, 0, 0);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        start = Instant.now();
        ans3 = dp3(0, 0, 0);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

//        Time taken: 769 milliseconds
//        Time taken: 0 milliseconds
//        Time taken: 0 milliseconds
//        2775
//        2392
//        2392
//        时间复杂度居然差这么多。。。。

        //Start coding
        System.out.println(ans1);   //dfs
        System.out.println(ans);    //dp
        System.out.println(ans3);   //dp3
//        System.out.println(half);

//        for (int[][] ints : dp3) {
//            for (int[] anInt : ints) {
//                for (int i : anInt) {
//                    System.out.print(i);
//                    System.out.print(" ");
//                }
//                System.out.println(" ");
//            }
//        }
    }

    public static void dfs(int left, int right, int deep, int temp) {
        if(left > half)
            return;
        if(right > half)
            return;
        if(deep > n) {
            return;
        }
//        System.out.println(" " + left + " " + right + " " + deep + " " + temp);
        if(deep < n){
            dfs(left + 1, right, deep + 1, temp + intput[deep][0]);
            dfs(left, right + 1, deep + 1, temp + intput[deep][1]);
        }
        if(deep == n && left == half && right == half) {
            ans1 = Math.max(ans1, temp);
//            if(ans1 != 0)
//                System.out.println(ans1);
            return;
        }

    }


    public static int dp(int left, int right, int deep) {
        if(dp[left][right] != 0)
            return dp[right][left];

        if(left > half)
            return 0;
        if(right > half)
            return 0;
        if(deep == n) {
            return 0;
        }
//        System.out.println(" " + left + " " + right + " " + deep + " " + temp);
        int a = dp(left + 1, right, deep + 1) + intput[deep][0];
        int b = dp(left, right + 1, deep + 1) + intput[deep][1];
//        System.out.println(a + "   " + b);
        dp[left][right] = Math.max(a, b);
        return dp[left][right];

    }

    public static int dp3(int left, int right, int deep) {
        if(dp3[left][right][deep] != 0)
            return dp3[right][left][deep];

        if(left > half)
            return 0;
        if(right > half)
            return 0;
        if(deep == n) {
            return 0;
        }
//        System.out.println(" " + left + " " + right + " " + deep + " " + temp);
        int a = dp3(left + 1, right, deep + 1) + intput[deep][0];
        int b = dp3(left, right + 1, deep + 1) + intput[deep][1];
//        System.out.println(a + "   " + b);
        dp3[left][right][deep] = Math.max(a, b);
        return dp3[left][right][deep];

    }
}
