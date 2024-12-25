package gold.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11689_GCDnk1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long result = solution(n);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static long solution(long n) {
        return eulerTotient(n);
    }


    private static long eulerTotient(long k) {
        long n = k;
        long p = 2;

        // 소인수 분해
        while (p <= Math.sqrt(k)) {
            if (k % p == 0) {
                // 소인수 p로 나누어 떨어질 때
                while (k % p == 0) {
                    k /= p;
                }
                n -= n / p; // φ(n) 계산, n = n * (1 - (1 / p))를 계산한 것
            }
            p++;
        }

        // k가 1보다 크고 소수인 경우 처리 ex) k = 13
        if (k > 1) {
            n -= n / k;
        }

        return n;
    }
}
