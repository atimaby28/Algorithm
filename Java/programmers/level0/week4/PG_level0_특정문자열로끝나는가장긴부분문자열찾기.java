package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_특정문자열로끝나는가장긴부분문자열찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String myString = st.nextToken();
        String pat = st.nextToken();

        String result = solution(myString, pat);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String myString, String pat) {
        String answer = "";

        int idx = myString.lastIndexOf(pat);

        answer = myString.substring(0, idx) + pat;

        return answer;
    }

}
