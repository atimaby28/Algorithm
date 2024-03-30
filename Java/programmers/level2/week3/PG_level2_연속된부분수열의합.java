package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_연속된부분수열의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(sequence, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int[] dp = new int[sequence.length];

        for (int i = 2; i < sequence.length; i++) {

            dp[i - 1] = sequence[i - 2] + sequence[ i - 1];

            for (int j = i; j < sequence.length; j++) {
                dp[j] = sequence[j] + dp[j - 1];

                if(dp[j - 1] == k) {
                    answer[0] = i - 2;
                    answer[1] = j - 1;
                    break;
                }

                if(dp[j] > k) {
                    break;
                }


            }

        }

        System.out.println(answer[0] + " " + answer[1]);

        return answer;
    }

}
