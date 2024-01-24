package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열뒤집기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String my_string = br.readLine();

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        String result = solution(my_string, s, e);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int s, int e) {
        String answer = "";

        char[] strChar = my_string.toCharArray();

        for (int i = 0; i < ((e - s)/ 2) + 1; i++) {
            char temp = strChar[e - i];
            strChar[e - i] = strChar[s + i];
            strChar[s + i] = temp;
        }

        for (char str : strChar) {
            answer += str;
        }

        return answer;
    }

}
