package com.arthur.luanqibazao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    static Set<Integer> hashSet = new HashSet<>();
    int i;
    Object a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return i == solution.i &&
                Objects.equals(a, solution.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, a);
    }

    public static int InversePairs(int [] array) {
        int len = array.length;
        if(array== null || len <= 0){
            return 0;
        }
        return mergeSort(array, 0, len-1);
    }
    public static int mergeSort(int [] array, int start, int end){
        if(start == end)
            return 0;
        int mid = (start + end) / 2;
        int left_count = mergeSort(array, start, mid);
        int right_count = mergeSort(array, mid + 1, end);
        int i = mid, j = end;
        int [] copy = new int[end - start + 1];
        int copy_index = end - start;
        int count = 0;
        while(i >= start && j >= mid + 1){
            if(array[i] > array[j]){
                if(!hashSet.contains(array[i])){
                    count += 1;
                }
                hashSet.add(array[i]);
                copy[copy_index--] = array[i--];
            }else{
                copy[copy_index--] = array[j--];
            }
        }
        while(i >= start){
            copy[copy_index--] = array[i--];
        }
        while(j >= mid + 1){
            copy[copy_index--] = array[j--];
        }
        i = 0;
        while(start <= end) {
            array[start++] = copy[i++];
        }
        return left_count + right_count + count;
    }

    public static void main(String[] args) {
        int[] intArr = {4, 6, 2, 3, 5, 1, 7, 8};
//        int[] intArr = new int[]{4, 3, 2, 1};
        int out = InversePairs(intArr);
        System.out.println(out);
    }
}