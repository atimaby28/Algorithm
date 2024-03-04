package level2.week1;

import java.io.*;

public class PG_level2_이진변환반복하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String s) {
        int[] answer = {};


        return answer;
    }

}
