package level2.week4;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PG_level2_석유시추 {

    static int[] oil;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][m];

        for (int i = 0; i < land.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(land);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] land) {
        int answer = 0;

        boolean[][] visited = new boolean[land.length][land[0].length];
        oil = new int[land[0].length];

        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    bfs(land, visited, i, j);
                }
            }
        }

        answer = Arrays.stream(oil).max().getAsInt();

        return answer;
    }

    public static void bfs(int[][] land, boolean[][] visited, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(new int[]{y, x});
        visited[y][x] = true;

        int count = 1;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            set.add(pos[1]);

            for(int i = 0; i < 4; i++) {
                int nx = pos[1] + dx[i];
                int ny = pos[0] + dy[i];

                if(nx < 0 || nx >= land[0].length || ny < 0 || ny >= land.length) continue;

                if(!visited[ny][nx] && land[ny][nx] == 1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    count += 1;
                }
            }
        }

        for(int idx : set) {
            oil[idx] += count;
        }
    }

}
/*
5 8
0 0 0 1 1 1 0 0
0 0 0 0 1 1 0 0
1 1 0 0 0 1 1 0
1 1 1 0 0 0 0 0
1 1 1 0 0 0 1 1

7 6
1 0 1 0 1 1
1 0 1 0 0 0
1 0 1 0 0 1
1 0 0 1 0 0
1 0 0 1 0 1
1 0 0 0 0 0
1 1 1 1 1 1
 */