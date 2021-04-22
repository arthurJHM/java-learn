package com.arthur.luanqibazao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(9, 2, 5, 1));
        System.out.println(sortGG(s));
    }
    static int  sortGG(List<Integer> s) {
        int count = 0;
        int maxs = s.get(0);
        for(int i = 1; i < s.size(); i++) {
            if(maxs < s.get(i)){
                maxs = s.get(i);
            }
            else{
                int temp = maxs;
                s.remove(s.get(i - 1));
                s.add(temp);
                count++;
                i = 0;
                maxs = s.get(i);
            }
        }
        return count;
    }

}
