package algorithm.lecture.ohheum.sort;

public class Code01 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 4, 9, 6, 8, 3, 2};
//        selectionSort(arr);
//        bubbleSort(arr);
//        insertionSort(arr);
//        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 선택 정렬
     */
    public static void selectionSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[0];
            int index = 0;
            for (int j = 0; j <= i; j++) {
                if (max < arr[j]) {
                    index = j;
                    max = arr[j];
                }
            }
            int tmp = arr[i];
            arr[i] = max;
            arr[index] = tmp;
        }
    }

    /**
     * 버블 정렬
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 삽입 정렬
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    arr[0] = tmp;
                } else if (arr[j-1] > tmp) {
                    arr[j] = arr[j-1];
                } else {
                    arr[j] = tmp;
                    break;
                }
            }
        }
    }

    /**
     * 병합정렬
     */
    public static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1, k = p;
        int[] tmp = new int[arr.length];

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= q) {
            tmp[k++] = arr[i++];
        }

        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        for (int l = p; l <= r; l++) {
            arr[l] = tmp[l];
        }
    }

    /**
     * 퀵 정렬
     */
    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r) {
        int i = p - 1, pivot = r;
        for (int j = p; j < r; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        i++;
        int tmp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = tmp;


        return i;
    }

}
