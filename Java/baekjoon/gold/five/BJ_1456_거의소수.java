package gold.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1456_거의소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static long solution(long a, long b) {
        return almostPrime(a, b);
    }

    private static long almostPrime(long a, long b) {

        int maxSqrt = (int) Math.sqrt(b);
        boolean[] isPrime = new boolean[maxSqrt + 1];

        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= maxSqrt; i++) {
            if(isPrime[i]) continue;

            // 여기서 평소 처럼 j = i * i를 하게되면 Overflow가 일어난다.
            for (int j = i + i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i <= maxSqrt; i++) {
            if (!isPrime[i]) {
                long power = (long) i * i;

                while (power <= b) {
                    if (power >= a) {
                        count++;
                    }

                    // power * i > b 이지만 역시 Overflow 문제로 변형
                    if (power > b / i) {
                        break;
                    }

                    power *= i;
                }
            }

        }

        return count;
    }
}
