package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_List {
    public static ArrayList<LinkedList<Integer>> graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Node
        int m = Integer.parseInt(st.nextToken()); // Edge
        int v = Integer.parseInt(st.nextToken()); // Starting Node

        visited = new boolean[n + 1];

        // graph에 연결 정보 채우기
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // DFS_Array(재귀함수 호출)
        dfs(v);
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int next = graph.get(idx).get(i);
            if(visited[next] == false) {
                dfs(next);
            }
        }

    }

}
