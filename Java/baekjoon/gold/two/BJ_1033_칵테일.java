package gold.two;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1033_칵테일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] ingredient = new int[n - 1][4];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
            ingredient[i][2] = Integer.parseInt(st.nextToken());
            ingredient[i][3] = Integer.parseInt(st.nextToken());
        }

        String result = solution(ingredient);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int[][] ingredient) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
