package gold.one;

import java.io.*;
import java.util.*;

public class BJ_17472_다리만들기2 {

    static int n, m;
    static int[][] map;
    static int[] parent;
    static List<int[]> edges;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution();

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution() {
        int landCount = labelIslands();

        findBridges(landCount);

        return kruskal(landCount);
    }

    private static int kruskal(int landCount) {
        parent = new int[landCount + 1];
        for (int i = 1; i <= landCount; i++) {
            parent[i] = i;
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int totalCost = 0, connectedEdges = 0;
        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);
            if (a != b) {
                union(a, b);
                totalCost += edge[2];
                connectedEdges++;
            }
        }
        return connectedEdges == landCount - 1 ? totalCost : -1;
    }

    private static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if(nx != ny) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static int labelIslands() {
        visited = new boolean[n][m];

        int islandNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, ++islandNum);
                }
            }
        }

        return islandNum;
    }

    private static void bfs(int y, int x, int islandNum) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = islandNum;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int cx = cur[1];
            int cy = cur[0];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if(!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = islandNum;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static void findBridges(int islandCount) {
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        int x = j, y = i, length = 0;
                        while (true) {
                            x += dx[d];
                            y += dy[d];

                            if (x < 0 || x >= m || y < 0 || y >= n || map[y][x] == map[i][j]) break;

                            if (map[y][x] > 0) {
                                if (length > 1) {
                                    edges.add(new int[]{map[i][j], map[y][x], length});
                                }
                                break;
                            }
                            length++;
                        }
                    }
                }
            }
        }
    }

}
