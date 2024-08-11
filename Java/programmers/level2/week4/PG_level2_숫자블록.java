package level2.week4;

import java.io.*;
import java.util.ArrayList;
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
        int[] answer = new int[(int) (end - begin + 1)];

        for (int i = 0; i <= end - begin; i++) {
            long n = begin + i;

            if (n == 1) {
                answer[i] = 0;
            } else {
                answer[i] = 1;

                for (int j = 2; j <= Math.sqrt(n); j++) {
                    if (n % j == 0) {
                        answer[i] = j;

                        if (n / j <= 10000000) {
                            answer[i] = (int) (n / j);
                            break;
                        }
                    }
                }

            }
        }

        return answer;
    }

}
