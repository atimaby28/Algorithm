package primeNumber;

public class FindPrimeNumber {
    public static void main(String[] args) {
        int k = 256;

        boolean primeNum = isPrime(k);

        System.out.println(primeNum);
    }

    private static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if(k % i == 0) {
                return false;
            }
        }
        return true;
    }

}
