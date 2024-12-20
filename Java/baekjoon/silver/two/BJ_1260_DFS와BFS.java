package silver.two;

import java.io.*;
import java.util.*;

public class BJ_1260_DFS와BFS {
    
    public static int N, M, V;

    public static boolean[] visited;

    public static StringBuilder sb;
    public static ArrayList<ArrayList<Integer>> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        arrayList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arrayList.get(from).add(to);
            arrayList.get(to).add(from);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            Collections.sort(arrayList.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void dfs(int v) {
        visited[v] = true;

        sb.append(v + " ");

        for (int nv : arrayList.get(v)) {
            if(!visited[nv]) {
                dfs(nv);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(v);

        visited[v] = true;

        while (!queue.isEmpty()) {
            int nv = queue.poll();

            sb.append(nv + " ");

            for (int vertex : arrayList.get(nv)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.offer(vertex);
                }
            }

        }
    }
}
