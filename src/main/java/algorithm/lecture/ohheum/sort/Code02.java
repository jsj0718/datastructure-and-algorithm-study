package algorithm.lecture.ohheum.sort;

public class Code02 {

    public static void main(String[] args) {
        int[] arr = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heapSort(arr);

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 힙 정렬
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0,  i);
        }
    }

    /**
     * 힙 만들기
     */
    public static void heapify(int[] arr, int i, int size) {
        int largest = i;
        int left = i * 2;
        int right = i * 2 + 1;

        if (size > left && arr[left] > arr[largest]) {
            largest = left;
        }

        if (size > right && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);

            heapify(arr, largest, size);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
