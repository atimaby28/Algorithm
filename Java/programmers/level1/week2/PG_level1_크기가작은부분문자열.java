package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_크기가작은부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String t = st.nextToken();

        String p = st.nextToken();

        int result = solution(t, p);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            if(Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }

}
