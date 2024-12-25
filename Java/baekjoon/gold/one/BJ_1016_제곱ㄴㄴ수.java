package gold.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long result = solution(min, max);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static long solution(long min, long max) {
        int size = (int) (max - min + 1);
        boolean[] isSquareFree = new boolean[size];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long square = i * i;

            // 제곱수의 배수 중 min 이상에서 시작
            long start = Math.max(square, ((min + square - 1) / square) * square);

            for (long j = start; j <= max; j += square) {
                isSquareFree[(int) (j - min)] = true;

            }
        }

        // 제곱ㄴㄴ수 개수 세기
        int count = 0;
        for (boolean free : isSquareFree) {
            if (!free) count++;
        }

        return count;
    }


}
