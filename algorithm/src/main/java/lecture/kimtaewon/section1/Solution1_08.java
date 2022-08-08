package lecture.kimtaewon.section1;

import java.util.Scanner;

public class Solution1_08 {

    public String solution(String str) {
        String answer = "NO";

        char[] cArr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;

        while(lt < rt) {
            if (!Character.isAlphabetic(cArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(cArr[rt])) {
                rt--;
            } else {
                if (Character.toUpperCase(cArr[lt]) != Character.toUpperCase(cArr[rt])) {
                    return answer;
                }
                lt++;
                rt--;
            }
        }

        answer = "YES";
        return answer;
    }

    public String solutionV2(String str) {
        String answer = "NO";

        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution1_08 T = new Solution1_08();
        System.out.println(T.solutionV2(str));
    }
}