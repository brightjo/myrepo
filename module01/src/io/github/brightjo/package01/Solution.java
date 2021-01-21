package io.github.brightjo.package01;

import java.util.*;
/*
* Ã°ÅÝ n^2 18ms
* ¹é²¢ nlogn
* */


class Solution {
    public static void MySort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        display(arr);
    }

    private static void display(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {22,43,24,25,9,8,6,43,41};
        long start = System.currentTimeMillis();
        MySort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Runtime:" + (end-start) + "ms");
    }
}