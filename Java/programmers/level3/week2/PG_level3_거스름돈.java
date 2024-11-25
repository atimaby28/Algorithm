package level3.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] money = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < money.length; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, money);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int n, int[] money) {
        // 나머지를 계산하기 위한 상수
        final int MOD = 1_000_000_007;

        // DP 배열 초기화
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무 동전도 사용하지 않음)

        // 동전 단위별로 DP 배열 업데이트
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        // 결과 반환
        return dp[n];
    }
}
