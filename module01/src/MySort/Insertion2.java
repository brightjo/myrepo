package MySort;

public class Insertion2 {
    public static void sort(double[] arr) {
        int L = arr.length;
        for (int i = 1; i < L; i++) {
            double tmp = arr[i];
            int j = 0;
            for(j = i; j > 0 && tmp < arr[j-1]; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
}