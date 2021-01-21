package MySort;

/*
 * 冒泡 n^2
 * 选择 n^2
 * 插入 n^2
 * 希尔 未知
 * 归并 nlogn
 *
 *
 *
 * */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class MySortMain {
    public static void display(double[] arr) {
        for (double i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static double[] distinctArr(double[] arr) {
        HashSet<Double> hashSet = new HashSet<Double>();
        for (double i : arr) {
            hashSet.add(i);
        }
        Double[] doubles = hashSet.toArray(new Double[]{});
        int L = doubles.length;
        double[] result = new double[L];
        for (int i = 0; i < L; i++) {
            result[i] = doubles[i].doubleValue();
        }
        return Arrays.stream(result).toArray();
    }

    public static double SortCompare(String alg, int N, int L) {
        long total = 0;
        double[] arr = new double[L];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                arr[j] = random.nextDouble();
            }
            long start = System.currentTimeMillis();
            switch (alg) {
                case "Maopao": { //冒泡
                    Maopao.sort(arr);
                    break;
                }
                case "Select": { //选择
                    Select.sort(arr);
                    break;
                }
                case "Insertion1": { //发现较大元素即交换版本 插入
                    Insertion1.sort(arr);
                    break;
                }
                case "Insertion2": { //发现较大元素即往后移动版本 插入
                    Insertion2.sort(arr);
                    break;
                }
                case "Shell1": { //原始版本希尔排序
                    Shell1.sort(arr);
                    break;
                }
                case "Shell2": { //使用sedgewick增量序列 平均时间复杂度 O^(7/6)
                    Shell2.sort(arr);
                    break;
                }
                case "Merge": { //has a trouble
                    Merge.sort(arr);
                    break;
                }
                case "Arrays.sort": { //使用Arrays.sort()排序
                    Arrays.sort(arr);
                    break;
                }
            }
            long end = System.currentTimeMillis();
            total += (end - start);
        }
        return (double)total;
    }

    public static void main(String[] args) {
        String alg1 = "Shell";
        String alg2 = "Insertion2";
        String s = "Arrays.sort";
        System.out.println(SortCompare(s,100,100)/100);
        //System.out.println(alg1 + " is " + SortCompare(alg2,100,10000)/SortCompare(alg1, 100, 10000) + " times " + "faster than " + alg2);
    }
}