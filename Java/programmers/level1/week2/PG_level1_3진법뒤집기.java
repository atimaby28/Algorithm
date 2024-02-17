package level1.week2;

import java.io.*;

public class PG_level1_3진법뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n) {
        int answer = 0;

        String temp = "";
        while (n > 0) {
            temp += n % 3;
            n /= 3;
        }

        answer = Integer.parseInt(temp, 3);

        return answer;
    }

}
