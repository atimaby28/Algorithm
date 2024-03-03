package level2.week1;

import java.io.*;
import java.util.Arrays;

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

        boolean[] blank = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                blank[i] = true;
            }
        }

        s = s.replaceAll("\\s+", " ");

        String[] str = s.split(" ");

        System.out.println(Arrays.toString(str));

        String temp = "";
        for (int i = 0; i < str.length; i++) {
            String big = str[i].substring(0, 1).toUpperCase();
            String last = str[i].substring(1).toLowerCase();

            str[i] = big + last;

            temp += str[i];
        }

        System.out.println(temp);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(blank[i] == true) {
                answer += " ";
            }

            if(blank[i] == false) {
                answer += temp.charAt(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        return answer;
    }

}
