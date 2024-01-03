package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;

        int fibo = func(n);

        System.out.println(fibo);
    }

    private static int func(int n) {
        // Base case
        if (n < 2) {
            return n;
        }

        // Recursive case
        return func(n - 1) + func(n - 2);

    }
}
