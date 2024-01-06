package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_대문자로바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        String result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String myString) {
        String answer = "";

        answer = myString.toUpperCase();

        return answer;
    }

}
