package recursion;

public class Power {
    public static void main(String[] args) {
        int base = 5;
        int expo = 2;

        int power = func(base, expo);

        System.out.println(power);
    }

    private static int func(int base, int expo) {
        // Base case
        if (expo == 1) {
            return base;
        }
        // Recursive case
        return base * func(base, expo - 1);
    }
}
