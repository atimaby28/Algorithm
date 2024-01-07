package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(func1(n));
        System.out.println(func2(n));
    }

    private static int func1(int n) {
        int ans = 1;
        for (int i = n; i > 0; i--) {
            ans *= i;
        }

        return ans;
    }

    private static int func2(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive case
        return n * func2(n-1);

    }

}
