package silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String result = solution(m, n);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int m, int n) {

        return eratosthenes(m, n);
    }

    private static String eratosthenes(int m, int n) {
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[n + 1];

        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(isPrime[i]) continue;

            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if(!isPrime[i])
                sb.append(i).append("\n");
        }

        return sb.toString();
    }
}
