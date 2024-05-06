package silver.two;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14465_소가길을건너간이유5 {

    public static int N, K, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean[] lights = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            lights[Integer.parseInt(br.readLine())] = true;
        }

        int result = solution(lights);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(boolean[] lights) {
        int answer = K;

        for (int i = 1; i <= (N - K) + 1; i++) {
            int lt = i, rt = lt + 6;
            int cnt = 0;
            for (int j = lt; j < rt; j++) {
                if(lights[j]) {
                    cnt++;
                }
            }

            answer = Math.min(answer, cnt);
        }

        return answer;

    }
}