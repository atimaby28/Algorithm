package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_주사위게임1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = solution(a, b);

        bw.write(a + b + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b) {
        int answer = 0;

        if(a % 2 != 0 && b % 2 != 0) {
            answer = a * a + b * b;
        } else if (a % 2 != 0 || b % 2 != 0) {
            answer = 2 * (a + b);
        } else {
            answer = Math.abs(a - b);
        }

        return answer;
    }

}
