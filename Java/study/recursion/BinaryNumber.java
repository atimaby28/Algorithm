package recursion;

public class BinaryNumber {
    public static void main(String[] args) {
        binaryNumber(28);
    }

    private static void binaryNumber(int number) {
        if(number == 0) {
            return;
        }

        binaryNumber(number / 2);

        System.out.print(number % 2);
    }
}
