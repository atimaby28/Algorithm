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
        int answer = 0;

        char firstChar = s.charAt(0);

        int firstCount = 0;
        int diffCount = 0;

        for(int i = 0; i < s.length(); i++) {

            if(firstCount == diffCount) {
                answer++;
                firstChar = s.charAt(i);
            }

            if(s.charAt(i) == firstChar) firstCount++;
            else diffCount++;

        }

        return answer;
    }

}
