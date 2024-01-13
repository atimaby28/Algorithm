package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String alp = st.nextToken();

        int result = solution(my_string, alp);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        if(str2.contains(str1)) {
            answer = 1;
        }

        return answer;
    }

}
