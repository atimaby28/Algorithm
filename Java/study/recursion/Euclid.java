package recursion;

/*
m >= n인 두 양의 정수 m과 n에 대하여 m이 n의 배수이면 gcd(m, n) = n이고,
그렇지 않으면 gcd(m, n) = gcd(n, m % n)이다.
*/
public class Euclid {
    public static void main(String[] args) {
        int a = 32;
        int b = 16;

        // int euclid_gcd = gcd(a, b);

        int euclid_gcd = gcd2(a, b);

        int euclid_lcm = lcm(a, b);

        System.out.println(euclid_gcd + " " + euclid_lcm);
    }

    private static int gcd(int a, int b) {
        // Base case
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd2(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd2(a, b);
    }

}
