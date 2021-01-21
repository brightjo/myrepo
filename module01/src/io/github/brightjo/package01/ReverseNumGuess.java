package io.github.brightjo.package01;

import java.math.BigInteger;
import java.util.Scanner;

public class ReverseNumGuess {

    public static boolean checkReverseNum(BigInteger bigInteger) {
        StringBuilder stringBuilder = new StringBuilder(bigInteger.toString());
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意一个正整数：");
        BigInteger bigInteger = scanner.nextBigInteger();
        System.out.print(bigInteger);
        while (!checkReverseNum(bigInteger)) {
            System.out.print(" " + "->" + " ");
            bigInteger = bigInteger.add(new BigInteger(new StringBuilder(bigInteger.toString()).reverse().toString()));
            System.out.print(bigInteger);
        }
        System.out.println();
    }

}
