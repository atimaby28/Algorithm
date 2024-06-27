package level2.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level2_당구연습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] balls = new int[a][b];

        for (int i = 0; i < balls.length; i++) {
            for (int j = 0; j < balls[0].length; j++) {
                balls[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(m, n, startX, startY, balls);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        Point border = new Point(m, n);
        Point start = new Point(startX, startY);

        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];

            List<Point> transBall = symmetricTransposition(border, start, new Point(ball[0], ball[1]));

            int minDistance = Integer.MAX_VALUE;

            for (Point point : transBall) {
                int dist = calculationDistance(start, point);

                minDistance = Math.min(minDistance, dist);
            }

            answer[i] = minDistance;
        }

        return answer;
    }

    private static List<Point> symmetricTransposition(Point bord, Point start, Point ball) {
        List<Point> syms = new ArrayList<>();

        // 4 개의 방향으로 대칭이동
        // 선 대칭일 때, 벽보다 공에 먼저 맞는 경우 제외
        if (!(start.x == ball.x && start.y > ball.y)) syms.add(new Point(ball.x, ball.y * -1));
        if (!(start.x == ball.x && start.y < ball.y)) syms.add(new Point(ball.x, bord.y + (bord.y - ball.y)));
        if (!(start.y == ball.y && start.x < ball.x)) syms.add(new Point(bord.x + (bord.x - ball.x), ball.y));
        if (!(start.y == ball.y && start.x > ball.x)) syms.add(new Point(ball.x * -1, ball.y));

        return syms;
    }

    private static int calculationDistance(Point start, Point ball) {
        int bigX = Math.max(start.x, ball.x);
        int smallX = Math.min(start.x, ball.x);
        int bigY = Math.max(start.y, ball.y);
        int smallY = Math.min(start.y, ball.y);

        return (int) Math.pow(bigX - smallX, 2) + (int) Math.pow(bigY - smallY, 2);
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
