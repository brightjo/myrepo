package MySort;

public class Shell2 {
    private static int[] D = new int[20]; //sedgewick增量序列

    static {
        int j = 0;
        int N = D.length/2;
        for (int i = 0; i < N; i++) {
            D[j++] = (int) (9 * Math.pow(4, i) - 9 * Math.pow(2, i) + 1);
            D[j++] = (int) (Math.pow(4, i + 2) - 3 * Math.pow(2, i + 2) + 1);
        }
    }

    public static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] > value) high = mid - 1;
            else if(arr[mid] < value) low = mid + 1;
            else return mid;
        }
        return high;
    }

    public static void sort(double[] arr) {
        int L = arr.length;
        int startIndex = binarySearch(D,L-1);
        while(startIndex >= 0) {
            int d = D[startIndex--];
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < L; j += d) {
                    double tmp = arr[j];
                    int k = i;
                    for (k = j; k > i && tmp < arr[k - d]; k -= d) {
                        arr[k] = arr[k - d];
                    }
                    arr[k] = tmp;
                }
            }
        }
    }
}
