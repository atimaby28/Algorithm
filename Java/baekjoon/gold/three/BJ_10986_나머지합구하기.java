package gold.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_10986_나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] array = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(array, m);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static long solution(long[] array, int m) {
        long answer = 0;

        // 1. 합 배열에 %m한 배열 구하기
        long[] sumArr = new long[array.length];

        sumArr[0] = array[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = (sumArr[i - 1] + array[i]);
        }

        // 2. 나누어 떨어진 갯수를 세는 배열
        long[] modArr = new long[m];

        for (int i = 0; i < sumArr.length; i++) {
            int remainder = (int) (sumArr[i] % m);

            if (remainder == 0) answer++;

            modArr[remainder]++;
        }

        for (int i = 0; i < modArr.length; i++) {
            if(modArr[i] > 1) {
                answer = answer + (modArr[i] * (modArr[i] - 1) / 2);
            }
        }

        return answer;
    }

}
