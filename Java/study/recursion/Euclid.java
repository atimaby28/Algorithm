package recursion;

    /*
    m >= n인 두 양의 정수 m과 n에 대하여 m이 n의 배수이면 gcd(m, n) = n이고,
    그렇지 않으면 gcd(m, n) = gcd(n, m % n)이다.
    */
public class Euclid {
    public static void main(String[] args) {
        int m = 3;
        int n = 52;

        // int euclid = func(m, n);

        int euclid = func2(m, n);

        System.out.println(euclid);
    }

    private static int func(int m, int n) {
        // Base case
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        if(m % n == 0) {
            return n;
        } else {
            return func(n, m % n);
        }
    }

    private static int func2(int p, int q) {
        if(q == 0) {
            return p;
        }

        return func2(q, p % q);
    }
}
