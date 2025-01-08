package gold.four;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_2251_물통 {

    static boolean[][][] visited;
    static Set<Integer> answer;
    static int[] capacity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        String result = solution(a, b, c);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        capacity = new int[]{a, b, c};
        visited = new boolean[a + 1][b + 1][c + 1];
        answer = new TreeSet<>(); // TreeSet을 사용하여 자동으로 정렬

        dfs(0, 0, c);

        for (int n : answer) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }

    static void dfs(int a, int b, int c) {
        if (visited[a][b][c]) return;

        visited[a][b][c] = true;

        if (a == 0) answer.add(c);

        // 모든 가능한 물 이동 방법을 시도
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int[] next = pour(new int[]{a, b, c}, i, j);
                    dfs(next[0], next[1], next[2]);
                }
            }
        }
    }

    static int[] pour(int[] state, int from, int to) {
        int[] next = state.clone();
        int amount = Math.min(state[from], capacity[to] - state[to]);
        next[from] -= amount;
        next[to] += amount;
        return next;
    }
}
