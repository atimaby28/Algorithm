package level2.week1;

import java.io.*;

public class PG_level2_멀리뛰기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static long solution(int n) {
        long answer = 0;

        int[] dp = new int[2010];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        answer = dp[n - 1];

        return answer;
    }

}
