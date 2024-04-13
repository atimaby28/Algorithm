package level0.week6;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_구슬을나누는경우의수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int balls = Integer.parseInt(st.nextToken());
        int share = Integer.parseInt(st.nextToken());

        int result = solution(balls, share);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(int balls, int share) {
        int answer = 0;

        answer = combination(balls, share);

        return answer;
    }

    private static int combination(int n, int r) {
        if(r == 0 || n == r) {
            return  1;
        }

        return combination(n-1, r-1) + combination(n-1, r);
    }

}
