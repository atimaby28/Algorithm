package numbers;

public class EulerTotient {
    public static void main(String[] args) {
        System.out.println(eulerTotient(13));
    }

    private static long eulerTotient(int k) {
        long n = k;
        long p = 2;

        // 소인수 분해
        while (p <= Math.sqrt(k)) {
            if (k % p == 0) {
                // 소인수 p로 나누어 떨어질 때
                while (k % p == 0) {
                    k /= p;
                }
                n = n * (1 - (1 / p)); // φ(n) 계산, n -= n / p라고 나타낼 수도 있다.
                System.out.println(k + " " + n);
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
