package recursion;

public class Fibonacci {

    public static int[] memoiFibo;
    public static void main(String[] args) {
        int n = 45;

        memoiFibo = new int[n + 1];

        int fibo = func(n);
        int fiboArray = func2(n);
        int fiboMemoization = func3(n);

        System.out.println(fibo);
        System.out.println(fiboArray);
        System.out.println(fiboMemoization);

    }

    private static int func(int n) {
        // Base case
        if (n < 2) {
            return n;
        }

        // Recursive case
        return func(n - 2) + func(n - 1);

    }

    private static int func2(int n) {
        // Base case
        if (n < 2) {
            return memoiFibo[n] = n;
        }

        // Recursive case & memoization
        return memoiFibo[n] = func2(n - 2) + func2(n - 1);
    }

    private static int func3(int n) {
        // Base case
        if (n < 2) {
            return memoiFibo[n] = n;
        }

        // Memoization
        if(memoiFibo[n] != 0) {
            return memoiFibo[n];
        }

        // Recursive case & memoization
        return memoiFibo[n] = func3(n - 2) + func3(n - 1);
    }

}
