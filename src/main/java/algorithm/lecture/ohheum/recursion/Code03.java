package algorithm.lecture.ohheum.recursion;

public class Code03 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(searchV1(data, data.length, target));
        System.out.println(searchV2(data, 0, data.length - 1, target));
        System.out.println(searchV3(data, 0, data.length, 3));
        System.out.println(findMaxV1(data, 0, data.length - 1));
        System.out.println(findMaxV2(data, 0, data.length - 1));

        String[] items = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
        String strTarget = "ghi";
        System.out.println(binarySearch(items, strTarget, 0, items.length));
    }

    public static int searchV1(int[] data, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int searchV2(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else if (data[begin] == target) {
            return begin;
        }

        return searchV2(data, begin + 1, end, target);
    }

    public static int searchV3(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            if (data[middle] == target) {
                return middle;
            }

            int index = searchV3(data, begin, middle - 1, target);
            if (index == -1) {
                return searchV3(data, middle + 1, end, target);
            } else {
                return index;
            }
        }
    }

    public static int findMaxV1(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], findMaxV1(data, begin + 1, end));
        }
    }

    public static int findMaxV2(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            int middle = (begin + end) / 2;
            int max1 = findMaxV2(data, begin, middle);
            int max2 = findMaxV2(data, middle + 1, end);

            return Math.max(max1, max2);
        }
    }

    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            int compareResult = target.compareTo(items[middle]);

            if (compareResult == 0) {
                return middle;
            } else if (compareResult < 0) {
                return binarySearch(items, target, begin, middle - 1);
            } else {
                return binarySearch(items, target, middle + 1, end);
            }

        }
    }
}
