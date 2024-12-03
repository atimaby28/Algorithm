package level3.week2;

import tree.Tree;

import java.io.*;
import java.util.*;

public class PG_level3_양과늑대 {

    static int maxSheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] info = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < info.length; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(info, edges);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int solution(int[] info, int[][] edges) {

        maxSheep = 0;

        // 트리 구성
        List<Node> nodes = buildTree(info, edges);


        // 탐색은 0번 루트 노드부터 시작
        List<Node> seekList = new ArrayList<>();
        seekList.add(nodes.get(0));

        // dfs 탐색
        dfs(seekList, 0, 0);

        return maxSheep;
    }

    // 트리를 구성하는 함수
    private static List<Node> buildTree(int[] info, int[][] edges) {
        List<Node> nodes = new ArrayList<>(info.length);

        // 노드 객체 생성
        for (int i = 0; i < info.length; i++) {
            nodes.add(new Node(info[i]));  // info[i] 값이 양(0) 또는 늑대(1)를 나타냄
        }

        Node parent, child;

        // 트리 구성
        for (int[] edge : edges) {
            parent = nodes.get(edge[0]);
            child = nodes.get(edge[1]);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        return nodes;
    }

    private static void dfs(List<Node> seek, int sheep, int wolf) {

        for (int i = 0; i < seek.size(); i++) {

            Node cur = seek.get(i);

            // 현재 노드가 양이면 sheep 증가, 늑대이면 wolf 증가
            int curS = sheep + (cur.data == 0 ? 1 : 0);  // 양은 data == 0
            int curW = wolf + (cur.data == 1 ? 1 : 0);   // 늑대는 data == 1

            // 늑대가 양보다 많거나 같으면 더 이상 탐색하지 않음
            if (curS <= curW) continue;

            // 최대 양 업데이트
            maxSheep = Math.max(maxSheep, curS);

            // 다음 탐색할 노드 리스트 구성
            List<Node> nextSeek = new ArrayList<>(seek);
            nextSeek.remove(cur);
            if (cur.left != null) nextSeek.add(cur.left);
            if (cur.right != null) nextSeek.add(cur.right);

            // 재귀 호출
            if (!nextSeek.isEmpty()) {
                dfs(nextSeek, curS, curW);
            }
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;  // 0은 양, 1은 늑대
        }
    }
}



/*
12
0 0 1 1 1 0 1 0 1 0 1 1
0 1
1 2
1 4
0 8
8 7
9 10
9 11
4 3
6 5
4 6
8 9
 */
