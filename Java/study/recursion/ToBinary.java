package recursion;

public class ToBinary {
    public static void main(String[] args) {

        int number = 8;

        printBinary(number);

    }

    private static void printBinary(int number) {
        if(number < 2) {
            System.out.print(number);
            return;
        }

        printBinary(number / 2);
        System.out.print(number % 2);
    }
}
