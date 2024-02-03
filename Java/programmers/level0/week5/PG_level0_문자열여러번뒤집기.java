package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열여러번뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String my_strings = br.readLine();

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] queries = new int[m][n];

        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String result = solution(my_strings, queries);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int[][] queries) {
        String answer = "";

        char[] charToStr = my_string.toCharArray();

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < ((queries[i][1] - queries[i][0]) / 2) + 1; j++) {
                char temp = charToStr[queries[i][0] + j];
                charToStr[queries[i][0] + j] = charToStr[queries[i][1] - j];
                charToStr[queries[i][1] - j] = temp;
            }
        }

        for (char c : charToStr) {
            answer += c;
        }

        return answer;
    }

}
