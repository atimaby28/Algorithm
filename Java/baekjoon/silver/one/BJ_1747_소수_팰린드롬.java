package silver.one;

import java.io.*;


public class BJ_1747_소수_팰린드롬 {
    static final int MAX = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int n) {
        boolean[] prime = eratosthenes();

        for (int i = n; i < prime.length; i++) {
            if(!prime[i]) {
                if(isPalindrome(i)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private static boolean isPalindrome(int n) {
        String number = String.valueOf(n);
        String reversed = new StringBuilder(number).reverse().toString();

        if(number.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean[] eratosthenes() {
        boolean[] isPrime = new boolean[MAX * 2];

        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if(isPrime[i]) continue;

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }

        return isPrime;
    }
}
