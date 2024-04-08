package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_행렬테두리회전하기 {

    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());

        map = new int[rows][columns];

        int k = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = k++;
            }
        }

        st = new StringTokenizer(br.readLine());

        int q_rows = Integer.parseInt(st.nextToken());
        int q_colums = Integer.parseInt(st.nextToken());

        int[][] queries = new int[q_rows][q_colums];

        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(rows, columns, queries);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        map = new int[rows][columns];

        int z = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = z++;
            }
        }

        int k = 0;
        for (int[] pos : queries) {
            answer[k] = Integer.MAX_VALUE;
            int startX = pos[1] - 1;
            int startY = pos[0] - 1;
            int endX = pos[3] - 1;
            int endY = pos[2] - 1;

            int cornorNum = map[startY][endX];

            for (int i = endX; i > startX; i--) {
                map[startY][i] = map[startY][i - 1];
                answer[k] = Math.min(answer[k], map[startY][i]);
            }

            int cornorNum2 = map[endY][endX];

            for (int i = endY; i > startY + 1; i--) {
                map[i][endX] = map[i - 1][endX];
                answer[k] = Math.min(answer[k], map[i][endX]);
            }

            map[startY + 1][endX] = cornorNum;
            answer[k] = Math.min(answer[k], map[startY + 1][endX]);

            int cornorNum3 = map[endY][startX];

            for (int i = startX; i < endX; i++) {
                map[endY][i] = map[endY][i + 1];
                answer[k] = Math.min(answer[k], map[endY][i]);
            }

            map[endY][endX - 1] = cornorNum2;
            answer[k] = Math.min(answer[k], map[endY][endX - 1]);

            for (int i = startY; i < endY; i++) {
                map[i][startX] = map[i + 1][startX];
                answer[k] = Math.min(answer[k], map[i][startX]);
            }

            map[endY - 1][startX] = cornorNum3;

            answer[k] = Math.min(answer[k], map[endY - 1][startX]);
            k++;
        }

        return answer;
    }

}
