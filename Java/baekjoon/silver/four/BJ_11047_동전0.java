package silver.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = solution(coins, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int[] coins, int k) {
        int answer = 0;

        int i = coins.length - 1;
        while (k > 0) {
            if(k / coins[i] == 0) {
                i--;
                continue;
            }

            answer += k / coins[i];
            k = k % coins[i];

        }

        return answer;
    }
}
