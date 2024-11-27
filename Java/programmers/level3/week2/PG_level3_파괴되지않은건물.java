package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_파괴되지않은건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        int[][] skill = new int[k][6];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                skill[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(board, skill);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        // 1. 누적합 배열 생성
        int[][] prefixSum = new int[n + 1][m + 1];

        // 2. 스킬을 누적합 배열에 적용
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[5] * (type == 1 ? -1 : 1); // 공격은 음수, 회복은 양수

            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2 + 1] -= degree;
            prefixSum[r2 + 1][c1] -= degree;
            prefixSum[r2 + 1][c2 + 1] += degree;
        }

        // 3. 누적합 계산
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }

        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        // 4. 최종 보드에 누적합 적용 및 파괴되지 않은 건물 개수 계산
        int intactBuildings = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += prefixSum[i][j];
                if (board[i][j] > 0) {
                    intactBuildings++;
                }
            }
        }

        return intactBuildings;
    }

}

/*
4 5
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
4
1 0 0 3 4 4
1 2 0 2 3 2
2 1 0 3 1 2
1 0 1 3 3 1
 */