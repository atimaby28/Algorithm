package level2.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_예상대진표 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = solution(n, a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n, int a, int b) {
        int answer = 1;

        while(Math.abs(a - b) != 1 || (a / 2 == b / 2)) {
            if(a % 2 != 0 && b % 2 != 0) {
                a = a / 2 + 1;
                b = b / 2 + 1;
            } else if(a % 2 != 0 && b % 2 == 0) {
                a = a / 2 + 1;
                b = b / 2;
            } else if(a % 2 == 0 && b % 2 != 0) {
                a = a / 2;
                b = b / 2 + 1;
            } else {
                a = a / 2;
                b = b / 2;
            }
            answer++;
        }

        while(a / 2 == b / 2) {

        }

        return answer;
    }

}
