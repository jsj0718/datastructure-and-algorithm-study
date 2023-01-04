package lecture.nadongbin.search;

public class 이진탐색 {
    public int binarySearchV1(int[] array, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (target == array[mid]) return mid;
        else if (target > array[mid]) return binarySearchV1(array, target, mid + 1, end);
        else return binarySearchV1(array, target, start, mid - 1);
    }

    public int binarySearchV2(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == array[mid]) return mid;
            else if (target > array[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
