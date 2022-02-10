package algorithm.lecture.ohheum.recursion;

public class Code03 {
	 public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(search(data, data.length, target));
    }

    public static int search(int[] data, int n, int target) {
        for (int i=0; i<n; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
