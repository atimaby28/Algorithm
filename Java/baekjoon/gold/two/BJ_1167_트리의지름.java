package gold.two;

import java.io.*;
import java.util.*;

public class BJ_1167_트리의지름 {

    static int maxDistance = 0; // 트리의 지름
    static int maxDistanceNode = 0; // 가장 먼 노드 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<List<TreeNode>> list = new ArrayList<>();

        // 트리 초기화
        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int child = Integer.parseInt(st.nextToken());
                if (child == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                list.get(parent).add(new TreeNode(child, weight));
            }
        }

        int result = solution(list, n);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(List<List<TreeNode>> list, int n) {
        // 첫 번째 DFS로 임의의 노드에서 가장 먼 노드를 찾는다
        boolean[] visited = new boolean[n + 1];
        dfs(list, 1, 0, visited); // 임의의 시작 노드(1)에서 DFS 시작

        // 두 번째 DFS로 가장 먼 노드에서 다시 가장 먼 노드를 찾는다
        visited = new boolean[n + 1]; // 방문 배열 초기화

        dfs(list, maxDistanceNode, 0, visited); // 두 번째 DFS

        return maxDistance;
    }

    // DFS 함수 (노드 번호, 현재까지의 거리, 방문 여부)
    static void dfs(List<List<TreeNode>> list, int node, int distance, boolean[] visited) {
        visited[node] = true;

        // 가장 먼 거리 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            maxDistanceNode = node; // 가장 먼 노드를 갱신
        }

        // 연결된 노드를 재귀적으로 방문
        for (TreeNode neighbor : list.get(node)) {
            int nextNode = neighbor.child;
            int weight = neighbor.weight;
            if (!visited[nextNode]) {
                dfs(list, nextNode, distance + weight, visited);
            }
        }
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
