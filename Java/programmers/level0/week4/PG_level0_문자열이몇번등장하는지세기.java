package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열이몇번등장하는지세기 {

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

        int i = 1;

        while((i + pat.length()) < myString.length()) {
            String temp = myString.substring(i, i + pat.length());

            if(temp.equals(pat)) {
                answer++;
            }

            i++;
        }

        return answer;
    }

}
