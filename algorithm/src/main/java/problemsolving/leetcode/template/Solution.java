package problemsolving.leetcode.template;

public class Solution {
    //시간 초과 -> O(n)으로 하는 방법 고려
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % 2 == 1) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[] {1,2,3,4,5,6,7}));
    }
}
