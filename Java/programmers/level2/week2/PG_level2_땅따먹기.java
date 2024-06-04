package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_땅따먹기 {

    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] land = new int[p][q];

        for (int i = 0; i < land.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(land);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i + 1]);
        }

        return answer;
    }

    /* dfs는 시간 초과
    public static int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            dfs(land, i, 0, land[0][i]);
        }

        answer = max;

        return answer;
    }

    private static void dfs(int[][] land, int x, int depth, int sum) {
        if(depth == land.length - 1){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < land[0].length; i++) {
            if(i == x) continue;
            dfs(land, i, depth + 1, sum + land[depth + 1][i]);
        }
    }
*/
}
