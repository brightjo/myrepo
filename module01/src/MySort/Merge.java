package MySort;

import java.util.Arrays;

public class Merge {
    public static double[] sort(double[] arr) {
        if(arr == null) return null;
        if(arr.length == 1) return arr;
        if(arr.length == 2) {
            if(arr[0] > arr[1]) {
                double tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
            return arr;
        }
        int len = arr.length;
        int mid = len%2 == 0 ? len/2-1 : len/2;
        double[] arr1 = Arrays.copyOfRange(arr,0,mid+1);
        double[] arr2 = Arrays.copyOfRange(arr,mid+1,len);
        return merge(sort(arr1),sort(arr2));
    }

    public static double[] merge(double[] l1, double[] l2) {
        if(l1 == null && l2 == null)    return null;
        if(l2 == null)  return l1;
        if(l1 == null)  return l2;
        int i = 0;
        int j = 0;
        int k = 0;
        int len1 = l1.length;
        int len2 = l2.length;
        double[] res = new double[len1 + len2];
        while (i < len1 && j < len2) {
            res[k++] = l1[i] > l2[j] ? l2[j++] : l1[i++];
        }
        if (i == len1) {
            while (j < len2) {
                res[k++] = l2[j++];
            }
        } else {
            while (i < len1) {
                res[k++] = l1[i++];
            }
        }
        return res;
    }
}
