package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_조건문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String ineq = st.nextToken();
        String eq = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = solution(eq, ineq, n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if(eq.equals("=")) {
            if(ineq.equals("<")) {
                if(n <= m) {
                    answer = 1;
                }
            } else {
                if(n >= m) {
                    answer = 1;
                }
            }
        } else {
            if(ineq.equals("<")) {
                if(n < m) {
                    answer = 1;
                }
            } else {
                if(n > m) {
                    answer = 1;
                }
            }
        }

        return answer;

    }

}
