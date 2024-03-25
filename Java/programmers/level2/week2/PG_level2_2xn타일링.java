package level2.week2;

import java.io.*;

public class PG_level2_2xn타일링 {

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

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] % 1000000007) + (dp[i - 2] % 1000000007);
        }

        answer = dp[n];

        return answer;
    }

}
