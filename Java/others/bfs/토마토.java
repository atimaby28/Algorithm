package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    public static int ans;
    public static int[][] box;

    public static Queue<TomatoPoint> queue = new LinkedList<>();

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        for (int i = 0; i < box.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < box[i].length; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new TomatoPoint(i, j, 0));
                }
            }
        }

        bfs();

        if (!tomatoCheck()) {
            ans = -1;
        }

        int result = ans;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    private static void bfs() {
        while (!queue.isEmpty()) {
            TomatoPoint point = queue.poll();
            int cx = point.x;
            int cy = point.y;
            int day = point.days;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < box[0].length && ny >= 0 && ny < box.length) {
                    if (box[ny][nx] == 0) {
                        queue.add(new TomatoPoint(ny, nx, day + 1));
                        box[ny][nx] = 1;
                    }
                }
            }
            ans = day;
        }
    }


    private static boolean tomatoCheck() {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}

class TomatoPoint {

    public int x;
    public int y;
    public int days;

    TomatoPoint(int y, int x, int days) {
        this.y = y;
        this.x = x;
        this.days = days;
    }

}