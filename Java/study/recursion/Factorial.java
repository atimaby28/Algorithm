package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;

        // for 문
        System.out.println(func1(n));

        // 하향식 재귀 -> 재귀를 사용하는 이유
        System.out.println(func2(n));

        // 상향식 재귀
        System.out.println(func3(n, 1, 1));
    }

    private static int func1(int n) {
        int ans = 1;
        for (int i = n; i > 0; i--) {
            ans *= i;
        }

        return ans;
    }

    // 하향식 재귀
    private static int func2(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive case
        return n * func2(n-1);

    }

    // 상향식 재귀
    private static int func3(int n, int i, int sum) {
        // Base case
        if (i > n) {
            return sum;
        }

        // Recursive case
        return func3(n, i + 1, sum * i);

    }

}
