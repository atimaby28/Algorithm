package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_두원사이의정수쌍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        long result = solution(r1, r2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

//    public static long solution(int r1, int r2) {
//        long answer = 0;
//
//        for (int x = 1; x <= r2; x++) {
//            int y2 = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
//            int y1 = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
//
//            answer += y2 - y1 + 1;
//        }
//
//        return answer * 4;
//    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        int edge = 0;
        for (int i = 0; i <= r2; i++) {
            long y2 = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            long y1 = (long) Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));

            // Edge를 체크하는 부분. 왜냐하면 r1이 경계의 포함여부에 따라 값이 달라지기 때문
            if (Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)) % 1 == 0) {
                edge++;
            }

            answer += (y2 - y1) * 4;

        }

        answer += edge * 4;
        answer -= 4; //x == r2 y == 0 일때 x == 0, y == r2 겹치는값 제거

        return answer;
    }

}
