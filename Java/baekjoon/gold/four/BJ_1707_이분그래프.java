package gold.four;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1707_이분그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[][] info = new int[e][2];

            for (int j = 0; j <= v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < info.length; j++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            String result = solution(graph, v);

            sb.append(result).append("\n");
        }

        bw.write(sb + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v + 1];
        int[] isBipartite = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            if(!dfs(graph, visited, isBipartite, i)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] isBipartite, int start) {
        visited[start] = true;

        for (int vertex : graph.get(start)) {
            if(!visited[vertex]) {
                isBipartite[vertex] = (isBipartite[start] + 1) % 2;
                dfs(graph, visited, isBipartite, vertex);
            } else if(isBipartite[vertex] == isBipartite[start]) {
                return false;
            }
        }

        return true;
    }

    // visited 배열을 사용하지 않는 풀이
//    private static String solution(ArrayList<ArrayList<Integer>> graph, int v) {
//        int[] colors = new int[v + 1]; // 0: 미방문, 1: 그룹 1, 2: 그룹 2
//
//        // 모든 노드에 대해 탐색 (연결 컴포넌트 처리)
//        for (int i = 1; i <= v; i++) {
//            if (colors[i] == 0) { // 아직 방문하지 않은 노드에 대해 DFS 수행
//                if (!dfs(graph, colors, i, 1)) {
//                    return "NO";
//                }
//            }
//        }
//        return "YES";
//    }
//
//    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] colors, int node, int color) {
//        colors[node] = color;
//
//        for (int neighbor : graph.get(node)) {
//            if (colors[neighbor] == 0) {
//                // 방문하지 않은 노드는 현재 노드의 반대 그룹으로 색칠
//                if (!dfs(graph, colors, neighbor, 3 - color)) {
//                    return false;
//                }
//            } else if (colors[neighbor] == colors[node]) {
//                // 이미 방문한 노드가 현재 노드와 같은 색이면 이분 그래프가 아님
//                return false;
//            }
//        }
//
//        return true;
//    }
}
