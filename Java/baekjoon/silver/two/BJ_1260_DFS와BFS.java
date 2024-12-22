package silver.two;

import java.io.*;
import java.util.*;

public class BJ_1260_DFS와BFS {

    public static StringBuilder sb;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arrayList.get(from).add(to);
            arrayList.get(to).add(from);
        }

        String result = solution(arrayList, v);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(ArrayList<ArrayList<Integer>> arrayList, int v) {
        sb = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            Collections.sort(arrayList.get(i));
        }

        visited = new boolean[arrayList.size() + 1];
        dfs(arrayList, v);

        sb.append("\n");

        visited = new boolean[arrayList.size() + 1];
        bfs(arrayList, v);

        return sb.toString();
    }

    private static void dfs(ArrayList<ArrayList<Integer>> arrayList, int v) {
        visited[v] = true;

        sb.append(v + " ");

        for (int nv : arrayList.get(v)) {
            if(!visited[nv]) {
                dfs(arrayList, nv);
            }
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> arrayList, int v) {
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
