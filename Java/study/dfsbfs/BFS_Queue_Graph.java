package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_Queue_Graph {

    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Node
        int m = Integer.parseInt(st.nextToken()); // Edge
        int v = Integer.parseInt(st.nextToken()); // Starting Node

        // graph에 연결 정보 채우기
        graph = new boolean[n +  1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        // BFS_Queue_Graph
        bfs(v);

    }

    // 너비우선탐색(큐)
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        visited[v] = true;

        while(!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");

            for(int i = 1; i < graph.length; i++) {
                if(visited[i] == false && graph[idx][i] == true) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
