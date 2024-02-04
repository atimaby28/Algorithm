package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열겹쳐서쓰기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String overwrite_string = st.nextToken();
        int s = Integer.parseInt(st.nextToken());

        String result = solution(my_string, overwrite_string, s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        String additional = "";

        additional = my_string.substring(s + overwrite_string.length(), my_string.length());
        my_string = my_string.substring(0, s);


        answer = my_string + overwrite_string + additional;

        return answer;
    }

//    public String solution(String my_string, String overwrite_string, int s) {
//        String before = my_string.substring(0, s);
//        String after = my_string.substring(s + overwrite_string.length());
//        return before + overwrite_string + after;
//    }

}
