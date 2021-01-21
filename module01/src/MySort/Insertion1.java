package MySort;

public class Insertion1 {
    public static void sort(double[] arr) {
        int L = arr.length;
        for (int i = 1; i < L; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                double tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}

