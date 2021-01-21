package MySort;

public class Shell1 {
    public static void sort(double[] arr) {
        int L = arr.length;
        for(int D = L/2; D > 0; D /= 2) {
            for(int i = 0; i < D; i++) {
                for(int j = i+D; j < L; j += D) {
                    double tmp = arr[j];
                    int k = i;
                    for(k = j; k > i && tmp < arr[k-D]; k -= D) {
                        arr[k] = arr[k-D];
                    }
                    arr[k] = tmp;
                }
            }
        }
    }
}
