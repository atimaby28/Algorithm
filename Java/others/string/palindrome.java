package string;

import java.io.*;
import java.util.Locale;

public class palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String result = palindrome_loop(str);

        bw.write(result);

        bw.flush();

        br.close();
        bw.close();
    }

    private static String palindrome_loop(String str) {
        String answer = "Yes";

        str = str.toUpperCase();

        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return "No";
            }
        }

        return answer;
    }

    private static String palindrome_stringBuilder(String str) {
        String answer = "Yes";

        String reverse = new StringBuilder(str).reverse().toString();

        if(!str.equalsIgnoreCase(reverse)) answer = "No";

        return answer;
    }

    private static String palindrome_regx(String str) {
        String answer = "Yes";

        // Only Alphabet
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String reverse = new StringBuilder(str).reverse().toString();

        if(!str.equalsIgnoreCase(reverse)) answer = "No";

        return answer;
    }

}
