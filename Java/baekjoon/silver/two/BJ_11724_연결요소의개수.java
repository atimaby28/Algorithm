package silver.two;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int result = solution(graph, n);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(List<List<Integer>> graph, int n) {
        int answer = 0;

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(graph, i);
            }
        }

        return answer;
    }

    private static void dfs(List<List<Integer>> graph, int node) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }

}
