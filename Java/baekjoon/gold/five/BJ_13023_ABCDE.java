package gold.five;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {

    static final int ABCDE = 5;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < s + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int result = solution(graph, s);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }


    private static int solution(List<List<Integer>> graph, int n) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(graph, i, 1)) { // dfs 결과 확인
                answer = 1;
                break;
            }
        }

        return answer;
    }

    private static boolean dfs(List<List<Integer>> graph, int start, int depth) {
        if (depth == ABCDE) { // 깊이 5 도달
            return true;
        }

        visited[start] = true;
        for (int vertex : graph.get(start)) {
            if (!visited[vertex]) {
                if (dfs(graph, vertex, depth + 1)) { // 재귀 결과 확인
                    return true;
                }
            }
        }
        visited[start] = false; // 백트래킹

        return false;
    }
}

/*
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
 */