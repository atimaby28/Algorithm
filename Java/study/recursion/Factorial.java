package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;

        int factorial = func(n);

        System.out.println(factorial);
    }

    private static int func(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive case
        return n * func(n-1);

    }
}
