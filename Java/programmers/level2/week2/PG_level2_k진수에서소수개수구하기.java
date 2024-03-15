package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_k진수에서소수개수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = solution(n, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int k) {
        int answer = -1;

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }

        String[] regex = sb.reverse().toString().split("0");

        for (int i = 0; i < regex.length; i++) {

            if(!regex[i].isEmpty()) {
                long num = Long.parseLong(regex[i]);

                if(num != 1 && isPrime(num)) {
                    answer++;
                }
            }
        }

        return answer + 1;
    }

    private static boolean isPrime(long num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
