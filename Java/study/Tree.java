import java.util.*;

public class Tree {

    public static void main(String[] args) {
        int[][] nodeInfo = {{0, 1, 2},
                {1, 3, 4},
                {2, -1, 5},
                {3, -1, -1},
                {4, -1, -1},
                {5, -1, -1}};

        TreeClass t = new TreeClass();

        for (int i = 0; i < nodeInfo.length; i++) {
            int a = nodeInfo[i][0];
            int b = nodeInfo[i][1];
            int c = nodeInfo[i][2];

            t.createNode(a, b, c);
        }

        System.out.println("전위 순회");
        t.preOrder(t.root);

        System.out.println("\n중위 순회");
        t.inOrder(t.root);

        System.out.println("\n후위 순회");
        t.postOrder(t.root);

        System.out.println("\n반복적 순회");
        t.iterativeOrder(t.root);

        System.out.println("\n레벨 순회");
        t.levelOrder(t.root);

        System.out.println("\n레벨별 노드");
        t.levelByLevel(t.root);

        System.out.println("\n트리 노드의 갯수");
        System.out.println(t.getNodeCount(t.root));

        System.out.println("\n트리 노드의 단말 노드 갯수");
        System.out.println(t.getLeafCount(t.root));

        System.out.println("\n트리의 높이");
        System.out.println(t.getHeight(t.root));
    }


    static class Node { //트리의 노드 정보를 저장할 클래스 구조체
        int data; //노드 값
        Node left; //왼쪽 자식 노드 참조 값
        Node right; //오른쪽 자식 노드 참조 값

        //추가할 때 참조되는 왼쪽, 오른쪽 자식의 값은 모르닌까 일단 data 값을 기반으로 Node 객체 생성
        Node(int data) {
            this.data = data;
        }
    }

    static class TreeClass {
        public Node root; //초기 root는 null

        public void createNode(int data, int leftData, int rightData) {
            if (root == null) {
                root = new Node(data);

                if (leftData != -1) {
                    root.left = new Node(leftData);
                }
                if (rightData != -1) {
                    root.right = new Node(rightData);
                }
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        public void searchNode(Node node, int data, int leftData, int rightData) {
            if (node == null) {
                return;
            } else if (node.data == data) {
                if (leftData != -1) {
                    node.left = new Node(leftData);
                }
                if (rightData != -1) {
                    node.right = new Node(rightData);
                }
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        //전위순회 Preorder : Root -> Left -> Right
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                if (node.left != null) preOrder(node.left);
                if (node.right != null) preOrder(node.right);
            }
        }

        //중위 순회 Inorder : Left -> Root -> Right
        public void inOrder(Node node) {
            if (node != null) {
                if (node.left != null) inOrder(node.left);
                System.out.print(node.data + " ");
                if (node.right != null) inOrder(node.right);
            }
        }

        //후위순회 Postorder : Left -> Right -> Root
        public void postOrder(Node node) {
            if (node != null) {
                if (node.left != null) postOrder(node.left);
                if (node.right != null) postOrder(node.right);
                System.out.print(node.data + " ");
            }
        }

        //반복적 순회 - Stack 사용
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

        //레벨 순회 - Queue 사용
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

        //레벨별 노드 출력
        public void levelByLevel(Node root) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.data);

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

                list.add(level);
            }

            for (ArrayList<Integer> i : list) {
                System.out.println(i);
            }
        }

        // 노드의 갯수
        public int getNodeCount(Node root) {
            int count = 0;

            if(root != null)
                count = 1 + getNodeCount(root.left) + getNodeCount(root.right);

            return count;
        }

        // 단말 노드의 갯수
        public int getLeafCount(Node root) {
            int count = 0;

            if(root != null) {
                if(root.left == null && root.right == null)
                    return 1;
                else
                    count = getLeafCount(root.left) + getLeafCount(root.right);
            }

            return count;
        }

        // 트리의 높이
        public int getHeight(Node root) {
            int height = 0;

            if(root != null)
                height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

            return height;
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
*/
