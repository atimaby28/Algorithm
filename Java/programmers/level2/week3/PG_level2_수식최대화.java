package level2.week3;

import java.io.*;

public class PG_level2_수식최대화 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();

        long result = solution(expression);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(String expression) {
        long answer = 0;

        String[] str = expression.split("\\*");

        for (String s : str) {
            System.out.println(s);
        }

        return answer;
    }

}
