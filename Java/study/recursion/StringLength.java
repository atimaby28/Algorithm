package recursion;

public class StringLength {
    public static void main(String[] args) {

        String str = "Hello World!";

        int strLen = intLen(str);

        System.out.println(strLen);

        printChars(str);

        System.out.println();

        printReverseChars(str);
    }

    private static int intLen(String str) {
        if(str.equals("")) {
            return 0;
        }

        return 1 + intLen(str.substring(1));
    }

    private static void printChars(String str) {
        if(str.length() == 0) {
            return;
        }
        System.out.print(str.charAt(0));
        printChars(str.substring(1));
    }

    private static void printReverseChars(String str) {
        if(str.length() == 0) {
            return;
        }
        printReverseChars(str.substring(1));
        System.out.print(str.charAt(0));
    }
}
