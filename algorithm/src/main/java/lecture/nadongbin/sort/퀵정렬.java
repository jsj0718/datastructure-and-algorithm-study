package lecture.nadongbin.sort;

public class 퀵정렬 {
    public int[] solution(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int start, int end) {
        //원소 개수가 1개 이하면 종료
        if (start >= end) return;

        //피벗은 항상 start 기준
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            //피벗보다 큰 수 찾기
            while (left <= end && arr[left] <= arr[pivot]) left++;
            //피벗보다 작은 수 찾기
            while (right > start && arr[right] >= arr[pivot]) right--;
            //엇갈린 경우 피벗과 right 위치 변경
            if (left > right) swap(arr, pivot, right);
            //그 외에는 left와 right 위치 변경
            else swap(arr, left, right);
        }

        //피벗 기준으로 병합 정렬
        quickSort(arr, 0, start - 1);
        quickSort(arr, start + 1, end);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
