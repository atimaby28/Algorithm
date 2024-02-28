package level1.week4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level1_문자열나누기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String s) {
        char first = s.charAt(0);
        int firstNum = 0;
        int diff = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (firstNum == diff) {
                result++;
                first = s.charAt(i);
            }
            if (s.charAt(i) == first) firstNum++;
            else diff++;
        }
        return result;
    }

}
