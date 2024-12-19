package gold.five;

import java.io.*;

public class BJ_2023_신기한소수 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = solution(n);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    public static String solution(int n) {
        sb = new StringBuilder();

        dfs(2, 1, n);
        dfs(3, 1, n);
        dfs(5, 1, n);
        dfs(7, 1, n);

        return sb.toString();
    }

    private static void dfs(int prime, int depth, int n) {
        if(depth == n) {
            sb.append(prime).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) continue;

            if(isPrime(prime * 10 + i)) {
                dfs(prime * 10 + i, depth + 1, n);
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0) {
                return false;
            }
        }

        return true;
    }

}
