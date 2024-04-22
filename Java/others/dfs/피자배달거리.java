package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 피자배달거리 {

    public static int ans = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[] visited;

    public static ArrayList<Point> pizzaPoint;
    public static ArrayList<Point> housePoint;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n, int m) {
        int answer = 0;

        pizzaPoint = new ArrayList<>();
        housePoint = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    housePoint.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    pizzaPoint.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[pizzaPoint.size()];
        combination(pizzaPoint.size(), m, 0);

        answer = ans;

        return answer;
    }

    private static void combination(int n, int r, int depth) {
        if(r == 0) {
            int sum = 0;
            for (int i = 0; i < housePoint.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < pizzaPoint.size(); j++) {
                    if(visited[j]) {
                        distance = Math.min(distance, Math.abs(housePoint.get(i).x - pizzaPoint.get(j).x)
                                + Math.abs(housePoint.get(i).y - pizzaPoint.get(j).y));
                    }
                }
                sum += distance;
            }

            ans = Math.min(ans, sum);

            return;
        }

        for (int i = depth; i < n; i++) {
            visited[i] = true;
            combination(n, r - 1, i + 1);
            visited[i] = false;
        }
    }

}

class Point {

    int x, y;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }

}


/*

input :
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

output :
6

 */