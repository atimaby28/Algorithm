package lis;

import java.io.*;
import java.util.StringTokenizer;

public class Lis_DP {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int n, int[] arr) {
        int answer = 0;

        int[] dp = new int[n];

        int max = 1;

        for (int i = 0; i < n; i++) {

            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        answer = max;

        return answer;
    }

}
