package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_Stack_Graph {
    public static void main(String[] args) throws IOException {

        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Node
        int m = Integer.parseInt(st.nextToken()); // Edge
        int v = Integer.parseInt(st.nextToken()); // Starting Node

        // graph에 연결 정보 채우기
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // DFS_Array_Graph(재귀함수 호출)
        dfs(v, graph, new boolean[n + 1]);

    }


    private static void dfs(int v, boolean[][] graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (stack.isEmpty() == false) {
            int idx = stack.pop();

            if (visited[idx]) {
                continue;
            }

            visited[idx] = true;
            System.out.print(idx + " ");

            for (int i = graph.length - 1; i >= 1; i--) {
                if (visited[i] == false && graph[idx][i] != false) {
                    stack.push(i);
                }
            }
        }

    }
}
