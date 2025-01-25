package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_스티커모으기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        int[] sticker = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sticker.length; i++) {
            sticker[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(sticker);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] sticker) {
        int n = sticker.length;

        if (n == 1) return sticker[0];

        return Math.max(maxStickerSum(Arrays.copyOfRange(sticker, 0, n - 1)),
                maxStickerSum(Arrays.copyOfRange(sticker, 1, n)));
    }

    private static int maxStickerSum(int[] sticker) {
        int n = sticker.length;

        if (n == 1) return sticker[0];

        int[] dp = new int[n];

        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        return dp[n - 1];
    }

}
