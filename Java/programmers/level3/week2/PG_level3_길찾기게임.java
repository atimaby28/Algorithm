package level3.week2;

import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_level3_길찾기게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        int[][] nodeinfo = new int[n][2];

        for (int i = 0; i < nodeinfo.length; i++) {
            st = new StringTokenizer(br.readLine());
            nodeinfo[i][0] = Integer.parseInt(st.nextToken());
            nodeinfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] result = solution(nodeinfo);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[nodeinfo.length][2];

        // 노드 정보를 TreeNode 객체로 변환
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new TreeNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // y 기준 내림차순, x 기준 오름차순 정렬
        nodes.sort((a, b) -> (a.y == b.y) ? Integer.compare(a.x, b.x) : Integer.compare(b.y, a.y));
        
        // 이진트리 구성
        TreeNode root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }

        // 전위 순회와 후위 순회 결과 저장
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        traversePreorder(root, preorder);
        traversePostorder(root, postorder);

        // stream을 사용해 배열로 변환
        answer = new int[2][];
        answer[0] = preorder.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postorder.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    // 이진트리에 노드를 삽입
    private static void insertNode(TreeNode parent, TreeNode child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    // 전위 순회
    private static void traversePreorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.id); // 현재 노드 방문
        traversePreorder(node.left, result); // 왼쪽 서브트리 탐색
        traversePreorder(node.right, result); // 오른쪽 서브트리 탐색
    }

    // 후위 순회
    private static void traversePostorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traversePostorder(node.left, result); // 왼쪽 서브트리 탐색
        traversePostorder(node.right, result); // 오른쪽 서브트리 탐색
        result.add(node.id); // 현재 노드 방문
    }

    static class TreeNode {
        int id, x, y;
        TreeNode left, right;

        TreeNode(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

}

/*
9
5 3
11 5
13 3
3 5
6 1
1 3
8 6
7 2
2 2
 */
