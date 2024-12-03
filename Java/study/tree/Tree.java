package tree;

import java.util.*;

public class Tree {
    public static void main(String[] args) {
        int[][] nodeInfo = {
                {0, 1, 2},
                {1, 3, 4},
                {2, -1, 5},
                {3, -1, -1},
                {4, -1, -1},
                {5, -1, -1}
        };

        TreeClass tree = new TreeClass();

        for (int[] node : nodeInfo) {
            tree.createNode(node[0], node[1], node[2]);
        }

        System.out.println("전위 순회");
        tree.preOrder(tree.root);

        System.out.println("\n중위 순회");
        tree.inOrder(tree.root);

        System.out.println("\n후위 순회");
        tree.postOrder(tree.root);

        System.out.println("\n반복적 순회");
        tree.iterativeOrder(tree.root);

        System.out.println("\n레벨 순회");
        tree.levelOrder(tree.root);

        System.out.println("\n레벨별 노드");
        tree.levelByLevel(tree.root);

        System.out.println("\n트리 노드의 갯수");
        System.out.println(tree.getNodeCount(tree.root));

        System.out.println("\n단말 노드 갯수");
        System.out.println(tree.getLeafCount(tree.root));

        System.out.println("\n트리의 높이");
        System.out.println(tree.getHeight(tree.root) - 1);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class TreeClass {
        Node root;

        // 노드 생성
        public void createNode(int data, int leftData, int rightData) {
            if (root == null) {
                root = new Node(data);
                if (leftData != -1) root.left = new Node(leftData);
                if (rightData != -1) root.right = new Node(rightData);
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        // 노드 탐색 및 추가
        private void searchNode(Node node, int data, int leftData, int rightData) {
            if (node == null) return;

            if (node.data == data) {
                if (leftData != -1) node.left = new Node(leftData);
                if (rightData != -1) node.right = new Node(rightData);
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        // 전위 순회 (Preorder: Root → Left → Right)
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        // 중위 순회 (Inorder: Left → Root → Right)
        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data + " ");
                inOrder(node.right);
            }
        }

        // 후위 순회 (Postorder: Left → Right → Root)
        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + " ");
            }
        }

        // 반복적 순회 (중위 순회)
        public void iterativeOrder(Node curr) {
            Stack<Node> stack = new Stack<>();
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }

        // 레벨 순회 (Level Order: BFS 방식)
        public void levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        // 레벨별 노드 출력
        public void levelByLevel(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.data);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                System.out.println(level);
            }
        }

        // 트리 노드 갯수
        public int getNodeCount(Node root) {
            if (root == null) return 0;
            return 1 + getNodeCount(root.left) + getNodeCount(root.right);
        }

        // 단말 노드 갯수
        public int getLeafCount(Node root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            return getLeafCount(root.left) + getLeafCount(root.right);
        }

        // 트리의 높이
        public int getHeight(Node root) {
            if (root == null) return 0;
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

}
/*

6
0 1 2
1 3 4
2 -1 5
3 -1 -1
4 -1 -1
5 -1 -1

    0
   / \
  1   2
 / \   \
3   4   5


전위 순회
0 1 3 4 2 5

중위 순회
3 1 4 0 2 5

후위 순회
3 4 1 5 2 0

반복적 순회
3 1 4 0 2 5

레벨 순회
0 1 2 3 4 5

레벨별 노드
[0]
[1, 2]
[3, 4, 5]

트리 노드의 갯수
6

단말 노드 갯수
3

트리의 높이
2
*/

