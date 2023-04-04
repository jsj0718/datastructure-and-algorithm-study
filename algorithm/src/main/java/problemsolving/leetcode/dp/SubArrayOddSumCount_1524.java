package problemsolving.leetcode.dp;

public class SubArrayOddSumCount_1524 {
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

    public int numOfSubarraysV2(int[] arr) {
        int count = 0;
        int[] dp = new int[arr.length];
        dp[0] = (arr[0] % 2 == 0) ? 0 : 1;
        count += dp[0];
        for (int i = 1; i < arr.length; i++) {
            //odd + even = odd, even + even = even 이므로 이전 항의 odd 수와 동일하다.
            if (arr[i] % 2 == 0) {
                dp[i] = dp[i - 1] % 1000000007;
            }
            //odd + odd = even, even + odd = odd 이므로 i + 1개에서 이전 항의 odd 수를 빼준 것과 동일하다.
            else {
                dp[i] = ((i + 1) - dp[i - 1]) % 1000000007;
            }
            count = (count + dp[i]) % 1000000007;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubArrayOddSumCount_1524().numOfSubarrays(new int[] {1,2,3,4,5,6,7}));
    }
}
