package level3.week1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PG_level3_섬연결하기 {

    static int[] unf;
    static List<Island> islands;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        islands = new ArrayList<>();

        for(int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            islands.add(new Island(from, to, cost));
        }

        unf = new int[n];

        for(int i = 0; i < n; i++) {
            unf[i] = i;
        }

        Collections.sort(islands);

        answer = kruskal(n);

        return answer;
    }

    private static int kruskal(int n) {
        int cost = 0, edgeCnt = 0;
        for(Island island : islands) {
            int from = find(island.from);
            int to = find(island.to);

            if(from != to) {
                cost += island.cost;
                edgeCnt++;
                union(from, to);
            }

            if(edgeCnt == n - 1) {
                return cost;
            }
        }

        return -1;
    }

    private static void union(int from, int to) {
        int u = find(from);
        int v = find(to);

        if(u != v) {
            unf[v] = u;
        }
    }

    private static int find(int x) {
        if(x == unf[x]) {
            return x;
        } else {
            return unf[x] = find(unf[x]);
        }
    }

    private static class Island implements Comparable<Island> {
        int from, to, cost;

        Island(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Island I) {
            return Integer.compare(this.cost, I.cost);
        }
    }
}


// Prim 버전

//import java.util.List;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//class Solution {
//
//    static boolean[] visited;
//    static List<List<Island>> islands;
//
//    public int solution(int n, int[][] costs) {
//        int answer = 0;
//
//        islands = new ArrayList<>();
//        visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            islands.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < costs.length; i++) {
//            int from = costs[i][0];
//            int to = costs[i][1];
//            int cost = costs[i][2];
//
//            islands.get(from).add(new Island(to, cost));
//            islands.get(to).add(new Island(from, cost)); // 양방향 추가
//        }
//
//        answer = prim(0, n);
//
//        return answer;
//    }
//
//    private static int prim(int start, int n) {
//        Queue<Island> pq = new PriorityQueue<>();
//        pq.offer(new Island(start, 0));
//
//        int cost = 0;
//        int count = 0; // 방문한 노드 수
//
//        while (!pq.isEmpty()) {
//            Island island = pq.poll();
//            int curIsland = island.next;
//            int costIsland = island.cost;
//
//            if (visited[curIsland]) continue;
//
//            visited[curIsland] = true;
//            cost += costIsland;
//            count++;
//
//            if (count == n) break;  // 모든 섬이 연결되었으면 종료
//
//            for (Island nextIsland : islands.get(curIsland)) {
//                if (!visited[nextIsland.next]) {
//                    pq.offer(new Island(nextIsland.next, nextIsland.cost));
//                }
//            }
//        }
//
//        return cost;
//    }
//
//    private static class Island implements Comparable<Island> {
//        int next, cost;
//
//        Island(int next, int cost) {
//            this.next = next;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Island I) {
//            return Integer.compare(this.cost, I.cost);
//        }
//    }
//}
