package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열바꿔서찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String myString = st.nextToken();
        String pat = st.nextToken();

        int result = solution(myString, pat);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(String myString, String pat) {
        int answer = 0;

        char[] changeStr = myString.toCharArray();

        String changedStr = "";

        for (char c : changeStr) {
            if(c == 'A') {
                c = 'B';
            } else {
                c = 'A';
            }

            changedStr += c;
        }

        if(changedStr.contains(pat)) {
            answer = 1;
        }

        return answer;
    }

}
