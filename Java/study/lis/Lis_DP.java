package lis;

import java.io.*;
import java.util.StringTokenizer;

public class Lis_DP {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(array);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int[] array) {
        int answer = 0;

        int[] dp = new int[array.length];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if(array[j] < array[i] && dp[j] > max)
                    max = dp[j];
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);

        }

        return answer;
    }

}

/*
8
5 3 7 8 6 2 9 4
 */

// 4
