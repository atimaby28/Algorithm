package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_특정한문자를대문자로바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String alp = st.nextToken();

        String result = solution(my_string, alp);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, String alp) {
        String answer = "";

        answer = my_string.replace(alp, alp.toUpperCase());

        return answer;
    }

}
