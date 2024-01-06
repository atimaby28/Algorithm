package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열앞의n글자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String my_string = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String result = solution(my_string, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static String solution(String my_string, int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            answer += my_string.charAt(i);
        }

        return answer;
    }
}
