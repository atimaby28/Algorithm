package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_숫자변환하기 {

    // public static int minVal = -1;
    // public static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int result = solution(x, y, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[y + 1];
        for (int i = x; i < y + 1; i++) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
        }

        answer = dp[y];

        return answer;

    }

//    public int solution(int x, int y, int n) {
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        Set<Integer> visited = new HashSet<>();
//        queue.add(x);
//        visited.add(x);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int cur = queue.poll();
//                if (cur == y) {
//                    return count;
//                }
//                if (cur + n <= y && !visited.contains(cur + n)) {
//                    queue.add(cur + n);
//                    visited.add(cur + n);
//                }
//                if (cur * 2 <= y && !visited.contains(cur * 2)) {
//                    queue.add(cur * 2);
//                    visited.add(cur * 2);
//                }
//                if (cur * 3 <= y && !visited.contains(cur * 3)) {
//                    queue.add(cur * 3);
//                    visited.add(cur * 3);
//                }
//            }
//            count++;
//        }
//        return -1;
//    }

//    private static void fk(int x, int y, int n, int cnt) {
//        if (x >= y) {
//
//            if (x == y) {
//                minVal = Math.min(cnt, 100);
//            }
//            System.out.println(cnt + " " + x);
//            return;
//        }
//
//        fk(x + n, y, n, cnt + 1);
//        fk(x * 2, y, n, cnt + 1);
//        fk(x * 3, y, n, cnt + 1);
//
//    }
//
//    private static void fk(int x, int y, int n, int cnt) {
//        if (x > y) {
//            return;
//        }
//        if (x == y) {
//            minVal = Math.min(minVal, cnt);
//            return;
//        }
//
//        fk(x + n, y, n, cnt + 1);
//        fk(x * 2, y, n, cnt + 1);
//        fk(x * 3, y, n, cnt + 1);
//
//    }

}
