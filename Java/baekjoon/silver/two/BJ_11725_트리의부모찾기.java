package silver.two;

import org.w3c.dom.Node;
import silver.one.BJ_1991_트리순회;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모찾기 {

    static int[] parents;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.add(new int[]{u, v});
        }

        // 결과 출력
        String result = solution(edges, n);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    // 부모 구하는 함수
    private static String solution(List<int[]> edges, int n) {
        visited = new boolean[n + 1];
        parents = new int[n + 1];  // 부모 정보를 저장하는 배열

        sb = new StringBuilder();

        // 트리 생성
        List<Node> nodes = buildTree(edges, n);

        // DFS로 부모 찾기 (1을 루트로 설정)
        dfs(nodes.get(1), 0);  // 루트는 1로 설정, 부모는 0으로 설정

        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }

        return sb.toString();
    }

    // DFS를 이용하여 부모 찾기
    private static void dfs(Node node, int parent) {
        if (node == null) return;

        // 부모 정보 저장
        parents[node.data] = parent;

        // 방문 처리
        visited[node.data] = true;

        // 자식 노드 탐색
        for (Node child : node.children) {
            if (!visited[child.data]) {
                dfs(child, node.data);
            }
        }
    }

    // 트리 생성 함수
    private static List<Node> buildTree(List<int[]> edges, int n) {
        List<Node> nodes = new ArrayList<>();

        // 노드 객체 생성
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }

        // 간선 정보를 통해 트리 연결
        for (int[] edge : edges) {
            Node parent = nodes.get(edge[0]);
            Node child = nodes.get(edge[1]);

            // 부모 노드에 자식 추가
            parent.children.add(child);
            child.children.add(parent);  // 양방향 연결
        }

        return nodes;
    }

    // 트리 노드 클래스
    static class Node {
        int data;
        List<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}
