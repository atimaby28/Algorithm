package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열섞기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        String result = solution(str1, str2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String str1, String str2) {
        String answer = "";

        for (int i = 0; i < str1.length(); i++) {
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }

        return answer;
    }

}
