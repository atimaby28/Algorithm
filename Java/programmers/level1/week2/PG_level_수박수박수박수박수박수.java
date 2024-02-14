package level1.week2;

import java.io.*;

public class PG_level_수박수박수박수박수박수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(int n) {
        String answer = "";

        answer = subak(answer, n);

        return answer;
    }

    private static String subak(String answer, int n) {
        if(n == 0) {
            return answer;
        }

        if(n % 2 != 0) {
            return subak(answer, n - 1) + "수";
        } else {
            return subak(answer, n - 1) + "박";
        }

    }
}
