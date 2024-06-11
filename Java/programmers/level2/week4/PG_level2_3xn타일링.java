package level2.week4;

import java.io.*;

public class PG_level2_3xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n) {
        int answer = 0;

        if (n % 2 == 1) return 0;

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[2] = 3;

        // f(6)은 n이 4인 경우에 따로 만들 수 있었던 모양 2가지에 n이 2인 경우를 각각 합해줄 수 있으므로 f(2) * 2가 추가된다. 즉 f(4) * 3 + f(2) * 2 + 2
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;

            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }

            dp[i] %= 1000000007;
        }

        answer = (int) dp[n];

        return answer;
    }

}
