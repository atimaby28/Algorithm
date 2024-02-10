package level1.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_두정수사이의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(int a, int b) {
        long answer = 0;

        int bigger = a;
        int smaller = b;

        if(a < b) {
            bigger = b;
            smaller = a;
        }

        for (int i = smaller; i <= bigger; i++) {
            answer += i;
        }

        return answer;
    }

//    public long solution(int a, int b) {
//        return sumAtoB(Math.min(a, b), Math.max(b, a));
//    }
//
//    private long sumAtoB(long a, long b) {
//        return (b - a + 1) * (a + b) / 2;
//    }

}
