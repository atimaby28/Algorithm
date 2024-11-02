package dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int coinNum = Integer.parseInt(br.readLine());

        int[] coins = new int[coinNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int result = solution(coinNum, coins, target);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int coinNum, int[] coins, int target) {
        int answer = 0;

        int[] dp = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < coinNum; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }

        }

        answer = dp[target];

        return answer;
    }

}
