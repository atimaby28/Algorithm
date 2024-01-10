package level0.week3;

import java.io.*;

public class PG_level0_문자열로변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        String result = solution(k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int n) {
        String answer = "";

        answer = String.valueOf(n);

        return answer;
    }

}
