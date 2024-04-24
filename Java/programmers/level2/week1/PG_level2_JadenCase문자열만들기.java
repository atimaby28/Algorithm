package level2.week1;

import java.io.*;
import java.util.Locale;

public class PG_level2_JadenCase문자열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String s) {
        String answer = "";
        String[] strArr = s.toLowerCase().split("");
        boolean flag = true;

        for(String str : strArr) {
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }

        return answer;
    }

//    public static String solution(String s) {
//        String answer = "";
//
//        StringBuilder sb = new StringBuilder();
//
//        s = s.toLowerCase();
//
//        sb.append(s.toUpperCase().charAt(0));
//
//        for (int i = 1; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//            if(s.charAt(i - 1) == ' ' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
//                sb.setCharAt(i, s.toUpperCase().charAt(i));
//            }
//        }
//
//        answer = sb.toString();
//
//        return answer;
//    }

}
