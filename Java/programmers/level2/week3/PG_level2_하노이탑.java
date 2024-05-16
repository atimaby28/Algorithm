package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_하노이탑 {

    public static int k = 0;
    public static int[][] log;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result[][] = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[][] solution(int n) {
        int[][] answer = {};

        log = new int[(int) (Math.pow(2, n) - 1)][2];

        hanoi(n, 1, 2, 3);

        answer = log;

        return answer;
    }

    public static void hanoi(int n, int from, int temp, int to) {

        if(n == 0) return;

        hanoi(n - 1, from, to, temp);
        log[k++] = new int[]{from, to};
        hanoi(n - 1, temp, from, to);

    }
}
