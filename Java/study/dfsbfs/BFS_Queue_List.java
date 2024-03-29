package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Queue_List {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);
    }

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();

            System.out.print("level " + level + " : ");
            for (int i = 0; i < levelNodeNum; i++) {
                Node curNode = queue.poll();
                System.out.print(curNode.data + " ");

                if(curNode.lt != null) {
                    queue.offer(curNode.lt);
                }

                if(curNode.rt != null) {
                    queue.offer(curNode.rt);
                }
            }
            level++;
            System.out.println();
        }
    }

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }

    }
}
