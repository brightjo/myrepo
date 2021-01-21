package io.github.brightjo.package01;

import java.util.Scanner;

public class SeqList {
    private int[] arr;
    private static Scanner scanner;
    private int length;

    public SeqList() {
        scanner = new Scanner(System.in);
        System.out.println("请输入数组容量：");
        int n = scanner.nextInt();
        arr = new int[n];
        length = 0;
    }



}
