package silver.one;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bluray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bluray.length; i++) {
            bluray[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, m , bluray);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int n, int m, int[] bluray) {
        int answer = 0;

        int start = Arrays.stream(bluray).max().orElseThrow();
        int end = Arrays.stream(bluray).sum();

        while (start <= end) {
            int middle = (start + end) / 2;

            int sum = 0, count = 0;

            for (int i = 0; i < n; i++) {
                if(sum + bluray[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum += bluray[i];
            }

            if(sum != 0) count++;

            if(count > m) start = middle + 1;
            else end = middle - 1;
        }

        answer = start;

        return answer;
    }


}
