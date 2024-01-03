package recursion;

public class SimpleSum {
    public static void main(String[] args) {
        int n = 5;

        int sum = func(n);

        System.out.println(sum);
    }

    private static int func(int n) {
        // Base case
        if (n <= 0) {
            return 0;
        }
        // Recursive case
        return n + func(n-1);
    }
}
