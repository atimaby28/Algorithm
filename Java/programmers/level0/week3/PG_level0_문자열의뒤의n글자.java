package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열의뒤의n글자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        String result = solution(my_string, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int n) {
        String answer = "";

        if(n == 0) {
            return answer;
        }

        return my_string.charAt(my_string.length() - n) + solution(my_string, n - 1);
    }
}
