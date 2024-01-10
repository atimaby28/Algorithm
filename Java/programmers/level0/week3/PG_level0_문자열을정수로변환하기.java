package level0.week3;

import java.io.*;

public class PG_level0_문자열을정수로변환하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n_str = br.readLine();

        int result = solution(n_str);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String n_str) {
        int answer = 0;

        answer = Integer.parseInt(n_str);

        return answer;
    }

}
