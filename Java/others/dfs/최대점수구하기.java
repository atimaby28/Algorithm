package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 최대점수구하기 {

    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] test = new int[n][2];

        for (int i = 0; i < test.length; i++) {
            st = new StringTokenizer(br.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(test, n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[][] test, int n, int m) {
        int answer = 0;

        dfs(test, n - 1, m, 0, 0);

        answer = ans;

        return answer;
    }

    private static void dfs(int[][] test, int n, int limit, int sum, int time) {
        if(time > limit) {
            return;
        }
        if(n < 0) {
            if(time <= limit) {
                ans = Math.max(ans, sum);
            }
            return;
        }

        dfs(test, n - 1, limit, sum + test[n][0], time + test[n][1]);
        dfs(test, n - 1, limit, sum, time);
    }

}

/*

input :
5 20
10 5
25 12
15 8
6 3
7 4

output :
41

 */