package recursion;

public class SimplePrint {
    public static void main(String[] args) {
        int n = 5;
        func(n);
    }

    private static void func(int n) {
        // Base case
        if (n <= 0) {
            return;
        }
        // Recursive case

        // Forward
        System.out.println("Recursion is starting from --> " + n);

        func(n - 1);

        // Reverse
        System.out.println("Recursion is starting from --> " + n);

    }
}
