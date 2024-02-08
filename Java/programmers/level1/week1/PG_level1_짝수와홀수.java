package level1.week1;

import java.io.*;

public class PG_level1_짝수와홀수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        String result = solution(num);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int num) {
        String answer = "";

        if(num % 2 != 0) {
            answer = "Odd";
        } else {
            answer = "Even";
        }

        return answer;
    }
}
