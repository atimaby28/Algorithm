package primeNumber;

public class Eratosthenes {
    public static void main(String[] args) {

        int k = 256;

        boolean[] findPrime = isPrimeFunc(k);

        for (int i = 2; i < findPrime.length; i++) {
            if(!findPrime[i]) {
                System.out.println(i);
            }
        }
    }

    private static boolean[] isPrimeFunc(int k) {
        boolean[] isPrime = new boolean[k + 1];

        isPrime[0] = true;
        isPrime[1] = true;

        if(k < 2) {
            return isPrime;
        }

        for (int i = 2; i < Math.sqrt(k); i++) {
            if(isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
        return isPrime;
    }

}
