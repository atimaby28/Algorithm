package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_특별한이차원배열1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }

}
