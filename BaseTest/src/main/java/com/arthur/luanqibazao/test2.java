package com.arthur.luanqibazao;

import java.util.*;
import java.lang.Integer;
public class test2 {
    public static Integer[] suhu(Integer[] nums) {
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
 /*int size=res.size();
 Integer[] array=(Integer[])res.toArray(new Integer[size]);*/
 /* Object[] objectArray  = res.toArray();
     Integer[] object2IntegerArray = new Integer[objectArray.length];
     for(int i=0;i<objectArray.length;i++){
         object2IntegerArray[i] =objectArray[i]; 
 return object2IntegerArray;*/
        Integer[] res1 = new Integer[res.size()];
        for(int i = 0; i < res.size(); i++)
        {
            res1[i] = (Integer) res.get(i);
        }
        return res1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str= str.substring(1,str.length()-1);
        String[] arr=str.split(",");
        Integer[] b = new Integer[arr.length];
        for(int j = 0; j<b.length;j++) {
            b[j] = Integer.parseInt(arr[j]);
        }
        Integer[] res =  suhu(b);
        for(Integer i : res){
            System.out.println(i);
        }

    }

}