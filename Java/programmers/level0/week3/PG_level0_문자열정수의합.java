package level0.week3;

import java.io.*;

public class PG_level0_문자열정수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num_str = br.readLine();

        int result = solution(num_str);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String num_str) {
        int answer = 0;

        answer = addStr(num_str, 0, 0);

        return answer;
    }

    private static int addStr(String numStr, int i, int sum) {
        if(i == numStr.length() - 1) {
            sum += (numStr.charAt(i) - '0');
            return sum;
        }

        return addStr(numStr, i + 1, sum + numStr.charAt(i) - '0');
    }

}
