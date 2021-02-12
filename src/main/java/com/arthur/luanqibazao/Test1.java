package com.arthur.luanqibazao;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 5, 11, 12};
        Integer[] ans = ques(nums);
    }
    public static Integer[] ques(Integer[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : nums){
            boolean isPrime = true;
            int k = (int) Math.sqrt(num);//k为num的正平方根，取整数
            for (int i = 2; i <= k; i++) {
                if (num % i == 0) {
                    isPrime = false;//不是素数
                    break;
                }
            }
            if(isPrime) {
                res.add(num);
                isPrime = true;
            }
        }
        System.out.println();

        Integer[] res1 = new Integer[res.size()];
        return res.toArray(res1);
    }
}
