package level2.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_줄서는방법 {

    public static int[] arr;
    public static int count = 0;
    public static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = solution(n, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] check = new boolean[n + 1];
        long[] factorial = new long[n];


        calFactorial(factorial, n);
        solve(factorial, answer, check, n, n - 1, k - 1, 1);

        return answer;
    }

    public static void calFactorial(long[] factorial, int n) {
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

    }

    public static void solve(long[] factorial, int[] answer, boolean[] check, int len, int n, long k, int idx) {
        //우선 현재  k / n - idx! 을 구해서
        if (n == -1) return;
        long result = k / factorial[n]; //
        answer[idx - 1] = selectNum(result, check, len);
        solve(factorial, answer, check, len, n - 1, k % factorial[n], idx + 1);
    }

    public static int selectNum(long result, boolean[] check, int len) {
        for (int i = 1; i <= len; i++) {
            if (!check[i]) {
                if (--result == -1) {
                    check[i] = true;
                    return i;
                }
            }
        }
        return 0;
    }

}
