package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14562_태권왕 {

//    public static int count = Integer.MAX_VALUE;
    public static final int MAX = 0x7fffffff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[][] score = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
        }

        String result = solution(score);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

//    public static String solution(int[][] score) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int k = 0; k < score.length; k++) {
//            dfs(score[k][0], score[k][1], 0);
//            sb.append(count + "\n");
//            count = Integer.MAX_VALUE;
//        }
//
//        return sb.toString();
//    }

//    public static void dfs(int s, int t, int cnt) {
//
//        if(s > t) {
//            return;
//        }
//
//        if(s == t) {
//            count = Math.min(count, cnt);
//            return;
//        }
//
//        dfs(s + s, t + 3, cnt + 1);
//        dfs(s + 1, t, cnt + 1);
//
//    }

    public static String solution(int[][] score) {
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < score.length; k++) {
            sb.append(dfs(score[k][0], score[k][1], 0)).append("\n");
        }

        return sb.toString();
    }

    public static int dfs(int s, int t, int cnt) {

        if (s >= t) {
            if (s == t) {
                return cnt;
            } else {
                return MAX;
            }
        }

        return Math.min(dfs(s << 1, t + 3, cnt + 1), dfs(s + 1, t, cnt + 1));
    }

}
