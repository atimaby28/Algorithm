package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1850_최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        String result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(long a, long b) {
        long len = gcd(a, b);

        String minusOne = "1";

        return minusOne.repeat((int)len);
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
