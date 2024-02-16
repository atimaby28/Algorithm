package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] result = solution(n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcdFunc(n, m);
        answer[1] = (n * m) / answer[0];

        return answer;
    }

    private static int gcdFunc(int n, int m) {
        if (m == 0) {
            return n;
        }

        return gcdFunc(m, n % m);
    }

}
