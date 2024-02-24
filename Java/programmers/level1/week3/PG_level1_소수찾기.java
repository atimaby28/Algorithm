package level1.week3;

import java.io.*;

public class PG_level1_소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n) {
        int answer = 0;


        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j * j <= i; j++) {
            if(i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
