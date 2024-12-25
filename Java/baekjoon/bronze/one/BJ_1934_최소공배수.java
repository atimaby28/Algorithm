package bronze.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[][] testCase = new int[t][2];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            testCase[i][0] = Integer.parseInt(st.nextToken());
            testCase[i][1] = Integer.parseInt(st.nextToken());
        }

        String result = solution(testCase);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int[][] testCase) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase.length; i++) {
            sb.append(lcm(testCase[i][0], testCase[i][1])).append("\n");
        }

        return sb.toString();
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
