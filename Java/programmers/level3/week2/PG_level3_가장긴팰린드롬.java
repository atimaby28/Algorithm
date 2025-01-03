package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_가장긴팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(String s) {
        // 가장 긴 문자열부터 팰린드롬 검사
        for (int i = s.length(); i > 1; i--) {

            // 시작 인덱스
            for (int j = 0; j + i <= s.length(); j++) {
                boolean chk = true;

                // 처음부터 문자열 길이의 반만큼 문자가 같은지 비교
                for (int k = 0; k < i / 2; k++) {
                    if (s.charAt(j + k) != s.charAt(j + i - k - 1)) {
                        chk = false;
                        break;
                    }
                }

                if (chk)
                    return i;
            }
        }

        // 모든 경우에 대해 팰린드롬이 없는 경우
        return 1;
    }

    class Solution {
        public static int solution(String s) {
            int n = s.length();

            // 가장 긴 길이부터 팰린드롬 검사
            for (int len = n; len > 1; len--) {  // 길이 len
                for (int start = 0; start + len <= n; start++) {  // 시작 위치 start
                    if (isPalindrome(s, start, start + len - 1)) {
                        return len;
                    }
                }
            }
            return 1;  // 모든 경우에 대해 팰린드롬이 없는 경우
        }

        // 팰린드롬 여부 확인 함수
        private static boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

//    public static int solution(String s) {
//        int n = s.length();
//
//        // 가장 긴 길이부터 팰린드롬 검사
//        for (int len = n; len > 1; len--) {  // 길이 len
//            for (int start = 0; start + len <= n; start++) {  // 시작 위치 start
//                if (isPalindrome(s, start, start + len - 1)) {
//                    return len;
//                }
//            }
//        }
//        return 1;  // 모든 경우에 대해 팰린드롬이 없는 경우
//    }
//
//    // 팰린드롬 여부 확인 함수
//    private static boolean isPalindrome(String s, int left, int right) {
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

}
