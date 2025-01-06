package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1991_트리순회 {

    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        tree = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // Java에서 char 데이터 타입은 내부적으로 ASCII 코드를 사용
            if (tree[data - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[data - 'A'] = new Node(data); // 부모 노드를 생성
            }
            if (left != '.') { // 왼쪽 자식이 존재할 경우
                tree[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
                tree[data - 'A'].left = tree[left - 'A']; // 부모 노드와 연결
            }
            if (right != '.') { // 오른쪽 자식이 존재할 경우
                tree[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
                tree[data - 'A'].right = tree[right - 'A']; // 부모 노드와 연결
            }

        }

        String result = solution(tree);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    public static void printTree(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        printTree(node.left);
        printTree(node.right);
    }

    private static String solution(Node[] tree) {
        sb = new StringBuilder();

        // printTree(tree[0]);

        // 전위 순회
        preorder(tree[0]);
        sb.append("\n");

        // 중위 순회
        inorder(tree[0]);
        sb.append("\n");

        // 후위 순회
        postorder(tree[0]);
        sb.append("\n");

        return sb.toString();
    }

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
