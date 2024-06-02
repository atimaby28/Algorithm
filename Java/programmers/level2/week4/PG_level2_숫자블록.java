package level2.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_숫자블록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long begin = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int[] result = solution(begin, end);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];

        int k = 0;
        for (long i = begin; i <= end; i++) {
            answer[k++] = maxPrime(i);
        }

        for (long g : answer) {
            System.out.println(g);
        }


        return answer;
    }

    private static int maxPrime(long i) {
        int ans = 1;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0) {
                ans = (int)i / j;
                break;
            }
        }

        if(i == 1) ans = 0;

        return ans;
    }

}
