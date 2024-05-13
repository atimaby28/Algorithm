package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_멀쩡한사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        long result = solution(w, h);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static long solution(int w, int h) {
        long answer = 1;

        int nw = Math.min(w, h);
        int nh = Math.max(w, h);

//      최대 공약수 -> (패턴 반복수)
        int gcd = gcd(nw, nh);

        int minW = nw / gcd;
        int minH = nh / gcd;

        /*
        minW * minH 에서 대각선을 지나지 않는 크기는 (minW-1) * (minH-1)
        cut: 패턴의 한부분 minW * minH 에서 잘리지 않는 부분을 뺀 것
        실제로는 w + h -1 과 같다.
        */

        int cut = (minW * minH) - ((minW - 1) * (minH - 1));

        answer = ((long) w * h) - ((long) cut * gcd);

        return answer;
    }

    private static int gcd(int nw, int nh) {
        if(nh == 0) {
            return nw;
        }
        return gcd(nh, nw % nh);
    }

}
