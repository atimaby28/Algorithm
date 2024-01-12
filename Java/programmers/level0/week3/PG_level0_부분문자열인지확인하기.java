package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_부분문자열인지확인하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String target = st.nextToken();

        int result = solution(my_string, target);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String my_string, String target) {
        int answer = 0;

        answer = my_string.contains(target) ? 1 : 0;

        return answer;
    }
}
