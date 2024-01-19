package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_두수의연산값비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b) {
        int answer = 0;

        String str = String.valueOf(a) + String.valueOf(b);

        if (Integer.parseInt(str) < 2 * a * b) {
            answer = 2 * a * b;
        } else {
            answer = Integer.parseInt(str);
        }

        return answer;
    }

}
