package MySort;

import static MySort.MySortMain.display;

public class Maopao {
    public static void sort(double[] arr) {
        int N = arr.length;
        for(int i = 1; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
