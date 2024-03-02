package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_바탕화면정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        String[] wallpaper = new String[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < wallpaper.length; i++) {
            wallpaper[i] = st.nextToken();
        }

        int[] result = solution(wallpaper);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        char[][] window = new char[wallpaper.length][wallpaper[0].length()];

        for (int i = 0; i < window.length; i++) {
            for (int j = 0; j < window[i].length; j++) {
                window[i][j] = wallpaper[i].charAt(j);
            }
        }

        int sx = 100, sy = 100;
        int ex = -1, ey = -1;
        for (int y = 0; y < window.length; y++) {
            for (int x = 0; x < window[y].length; x++) {
                if(window[y][x] == '#' && x < sx) {
                    sx = x;
                }

                if(window[y][x] == '#' && y < sy) {
                    sy = y;
                }

                if(window[y][x] == '#' && x > ex) {
                    ex = x;
                }

                if(window[y][x] == '#' && y > ey) {
                    ey = y;
                }
            }
        }

        answer[0] = sy;
        answer[1] = sx;
        answer[2] = ey + 1;
        answer[3] = ex + 1;

        return answer;
    }

}
