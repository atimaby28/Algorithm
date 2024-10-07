package gold.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] bag = new int[n][2];

        for (int i = 0; i < bag.length; i++) {
            st = new StringTokenizer(br.readLine());

            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(bag, k);

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] bag, int k) {
        int answer = 0;

        int[][] dp = new int[bag.length][2];

        for (int i = 0; i < bag.length; i++) {

        }

        return answer;
    }
}
