package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리 {
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int[] distance;

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
//            graph[y][x] = true;
        }

        distance = new int[n + 1];

        // BFS_Queue_Graph
        bfs(v);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + distance[i]);
        }

    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {

            int cv = queue.poll();

            for (int i = 1; i < graph.length; i++) {

                if(visited[i] == false && graph[cv][i] == true) {
                    visited[i] = true;
                    queue.offer(i);
                    distance[i] = distance[cv] + 1;

                }
            }
        }
    }


}

/*

input :
6 9 1
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

output :
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2

 */
