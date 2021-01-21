package MySort;

import static MySort.MySortMain.display;

public class Select {
    public static void sort(double[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min])  {
                    min = j;
                }
            }
            if(min != i) {
                double tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}

