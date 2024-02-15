package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_문자열다루기기본 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        boolean result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static boolean solution(String s) {
        boolean answer = false;

        if((s.length() == 4 || s.length() == 6) && isAllDigit(s)) {
            answer = true;
        }

        return answer;
    }

    private static boolean isAllDigit(String s) {

        String temp = s.replaceAll("[A-z]", "");

        System.out.println(s + " " + temp);

        if(temp.length() == s.length()) {
            return true;
        } else {
            return false;
        }

    }

}
