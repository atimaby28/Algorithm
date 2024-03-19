package level2.week2;

import java.io.*;
import java.util.HashMap;

public class PG_level2_방문길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String dirs) {
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(1, 2);
        hashMap.put(2, 1);
        hashMap.put(3, 4);
        hashMap.put(4, 3);

        boolean[][][] visited = new boolean[11][11][5];
        int x = 5, y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            int nx = x, ny = y;
            int idxC = 0;

            if(c == 'U') {
                ny = y + 1;
                idxC = 1;
            } else if(c == 'D') {
                ny = y - 1;
                idxC = 2;
            } else if(c == 'L') {
                nx = x - 1;
                idxC = 3;
            } else if(c == 'R') {
                nx = x + 1;
                idxC = 4;
            }

            if(ny >=0 && ny < visited.length && nx >= 0 && nx < visited.length) {

                if(!visited[nx][ny][idxC]) {
                    visited[nx][ny][idxC] = true;
                    visited[x][y][hashMap.get(idxC)] = true;
                    answer++;
                }

                x = nx;
                y = ny;
            }

        }

        return answer;
    }

}
