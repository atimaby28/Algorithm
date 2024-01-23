package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_세로읽기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String my_string = br.readLine();

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String result = solution(my_string, m, c);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int m, int c) {
        String answer = "";

        for (int i = c - 1; i < my_string.length(); i += m) {
            answer += my_string.charAt(i);
        }
        return answer;
    }

}
