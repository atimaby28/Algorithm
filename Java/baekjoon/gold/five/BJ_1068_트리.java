package gold.five;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1068_트리 {

    static int cnt;   // 리프 노드 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] parents = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        int deleteNode = Integer.parseInt(br.readLine());

        // 결과 출력
        int result = solution(parents, deleteNode);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int[] parents, int deleteNode) {
        // 트리 생성
        Node root = buildTree(parents);

        // 루트 노드 삭제 처리
        if (root.data == deleteNode) {
            return 0;
        }

        // DFS 탐색으로 리프 노드 개수 계산
        cnt = 0;
        dfs(root, deleteNode);

        return cnt;
    }

    private static void dfs(Node current, int deleteNode) {
        // 삭제 노드인 경우 탐색 중지
        if (current.data == deleteNode) {
            return;
        }

        // 자식이 없는 경우 리프 노드로 카운트
        if (current.children.isEmpty() ||
                (current.children.size() == 1 && current.children.get(0).data == deleteNode)) {
            cnt++;
            return;
        }

        // 자식 노드 탐색
        for (Node child : current.children) {
            dfs(child, deleteNode);
        }
    }

    private static Node buildTree(int[] parents) {
        int n = parents.length;
        Node[] nodes = new Node[n];

        // 모든 노드 생성
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;

        // 부모-자식 관계 설정
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = nodes[i]; // 루트 노드 설정
            } else {
                nodes[parents[i]].children.add(nodes[i]);
            }
        }

        return root;
    }

    static class Node {
        int data;
        List<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}
