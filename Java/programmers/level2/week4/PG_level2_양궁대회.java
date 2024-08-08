package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_양궁대회 {
    public static int max, ans[], apeach[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] info = new int[11];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < info.length; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(n, info);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int n, int[] info) {

        apeach = info;

        for (int i = 1; i < 1 << 11; i++)
            if (Integer.bitCount(i) <= n) find(n, i);

        return max == 0 ? new int[]{-1} : ans;
    }

    public static void find(int n, int cur) {
        int score = 0, state[] = new int[11];
        for (int i = 1; i <= 10; i++) {
            if ((cur & 1 << i) > 0) {
                n -= state[10 - i] = apeach[10 - i] + 1;
                if (n < 0) return;
                score += i;
            } else if (apeach[10 - i] > 0) score -= i;
        }
        if (score <= 0) return;
        state[10] = n;
        if (max < score) {
            max = score;
            ans = state;
        } else if (max == score) {
            for (int i = 10; i >= 0; i--) {
                if (ans[i] != state[i]) {
                    if (state[i] > ans[i])
                        ans = state;
                    return;
                }
            }
        }
    }


}
