package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_부분문자열이어붙여문자열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] my_strings = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < my_strings.length; i++) {
            my_strings[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] parts = new int[m][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                parts[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String result = solution(my_strings, parts);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String[] my_strings, int[][] parts) {
        String answer = "";

        for (int i = 0; i < my_strings.length; i++) {
            answer += my_strings[i].substring(parts[i][0], parts[i][1] + 1);
        }

        return answer;
    }

}
