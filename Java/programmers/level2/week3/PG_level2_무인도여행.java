package level2.week3;

import java.io.*;
import java.util.*;

public class PG_level2_무인도여행 {
    public static char[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        String[] maps = new String[k];

        for (int i = 0; i < maps.length; i++) {
            maps[i] = br.readLine();
        }

        int[] result = solution(maps);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] maps) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();

        // graph에 연결 정보 채우기
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    arrayList.add(bfs(i, j));
                }
            }
        }

        if(arrayList.size() == 0){
            arrayList.add(-1);
        }
        Collections.sort(arrayList);

        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        int sum = 0;

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];

            sum += (map[cx][cy] - '0');

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if(!visited[nx][ny] && map[nx][ny] != 'X') {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
        return sum;
    }

}
