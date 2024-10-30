package string;

import java.io.*;
import java.util.Locale;

public class palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String result = solution(str);

        bw.write(result);

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(String str) {
        String answer = "YES";

        str = str.toUpperCase();

        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return "No";
            }
        }

        return answer;
    }
}
