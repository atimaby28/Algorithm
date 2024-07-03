package dp;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class 부분증가수열 {

    public static void main(String[] args) throws IOException {
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

        int[] dp = new int[arr.length];

        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && max < dp[j]) max = dp[j];
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);

        }

        return answer;
    }

}
