package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의최단거리통로 {

    public static int ans;
    public static int[][] map;
    public static boolean[][] visted;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visted = new boolean[n + 1][n + 1];

        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visted[1][1] = true;
        bfs(1, 1);

        int result = ans;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static void bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(y, x));

        visted[y][x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            

        }
    }



}

class Point {

    public int x;
    public int y;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
