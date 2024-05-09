package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_거리두기확인하기 {

    public static int[] manhattanX = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] manhattanY = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static StringTokenizer st;
    public static final int ROW = 5, COL = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] places = new String[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                places[i][j] = st.nextToken();
            }
        }

        int[] result = solution(places);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        char[][] workplace;

        for (int testCase = 0; testCase < places.length; testCase++) {

            workplace = new char[ROW][COL];

            for (int i = 0; i < ROW; i++) {
                st = new StringTokenizer(places[testCase][i]);
                workplace[i] = st.nextToken().toCharArray();
            }
            answer[testCase] = haveDist(workplace);
        }

        return answer;
    }

    public static int haveDist(char[][] workplace) {
        int isTrue = 1;

        for (int cy = 0; cy < ROW; cy++) {
            for (int cx = 0; cx < COL; cx++) {

                if(workplace[cy][cx] == 'P') {
                    for (int k = 0; k < 4; k++) {

                        for (int x = 1; x <= 2; x++) {
                            int nx = cx + (manhattanX[k] * x);
                            int ny = cy + (manhattanY[k] * x);

                            if(nx < 0 || nx >= COL || ny < 0 || ny >= ROW) continue;

                            if(workplace[ny][nx] == 'X') break;

                            if(workplace[ny][nx] == 'P') {
                                return 0;
                            }
                        }
                    }

                    for (int k = 4; k < 8; k++) {
                        int nx = cx + manhattanX[k];
                        int ny = cy + manhattanY[k];

                        if(nx < 0 || nx >= COL || ny < 0 || ny >= ROW
                                || workplace[ny][nx] == 'X') continue;

                        if(workplace[ny][nx] == 'P' && k == 4) {
                            if(workplace[cy + manhattanY[0]][cx + manhattanX[0]] != 'X'
                                    || workplace[cy + manhattanY[2]][cx + manhattanX[2]] !='X') {
                                return 0;
                            }
                        } else if(workplace[ny][nx] == 'P' && k == 5) {
                            if(workplace[cy + manhattanY[0]][cx + manhattanX[0]] != 'X'
                                    || workplace[cy + manhattanY[3]][cx + manhattanX[3]] !='X') {
                                return 0;
                            }
                        } else if(workplace[ny][nx] == 'P' && k == 6) {
                            if(workplace[cy + manhattanY[1]][cx + manhattanX[1]] != 'X'
                                    || workplace[cy + manhattanY[2]][cx + manhattanX[2]] !='X') {
                                return 0;
                            }
                        } else if(workplace[ny][nx] == 'P' && k == 7) {
                            if(workplace[cy + manhattanY[1]][cx + manhattanX[1]] != 'X'
                                    || workplace[cy + manhattanY[3]][cx + manhattanX[3]] !='X') {
                                return 0;
                            }
                        }

                    }
                }

            }
        }

        return isTrue;
    }

}