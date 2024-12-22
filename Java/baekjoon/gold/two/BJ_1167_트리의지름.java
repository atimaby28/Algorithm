package gold.two;

import java.io.*;
import java.util.*;

public class BJ_1167_트리의지름 {

    static int maxDistance = 0; // 트리의 지름
    static int maxDistanceNode = 0; // 가장 먼 노드 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<List<TreeNode>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int child = Integer.parseInt(st.nextToken());
                if (child == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                list.get(parent).add(new TreeNode(child, weight));
            }
        }

        // 첫 번째 탐색: DFS로 임의의 노드에서 가장 먼 노드 찾기
        boolean[] visited = new boolean[n + 1];
        dfs(list, 1, 0, visited);

        // 두 번째 탐색: BFS로 가장 먼 거리 계산
        int maxDistance = bfs(list, n, maxDistanceNode);

        bw.write(maxDistance + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    // DFS 함수
    private static void dfs(List<List<TreeNode>> list, int node, int distance, boolean[] visited) {
        visited[node] = true;

        // 가장 먼 거리 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            maxDistanceNode = node;
        }

        for (TreeNode neighbor : list.get(node)) {
            if (!visited[neighbor.child]) {
                dfs(list, neighbor.child, distance + neighbor.weight, visited);
            }
        }
    }

    // BFS 함수
    private static int bfs(List<List<TreeNode>> list, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 노드, 거리
        visited[start] = true;

        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            for (TreeNode neighbor : list.get(node)) {
                if (!visited[neighbor.child]) {
                    visited[neighbor.child] = true;
                    queue.add(new int[]{neighbor.child, distance + neighbor.weight});
                    maxDistance = Math.max(maxDistance, distance + neighbor.weight);
                }
            }
        }

        return maxDistance;
    }

    // 트리 노드 클래스
    static class TreeNode {
        int child, weight;

        TreeNode(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }
    }
}
