package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] results = new int[n][2];

        for (int i = 0; i < results.length; i++) {
            st = new StringTokenizer(br.readLine());
            results[i][0] = Integer.parseInt(st.nextToken());
            results[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, results);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;

        answer = floydWarshall(n, results);

        return answer;
    }

    private static int floydWarshall(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];

        // 경기 결과 입력
        for (int[] result : results) {
            win[result[0]][result[1]] = true; // A가 B를 이겼다.
        }
        // 플로이드-워셜 알고리즘으로 승패 관계 확장
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        // 확실한 순위를 매길 수 있는 선수 찾기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }
            // 자신을 제외한 n-1명의 선수와 승패 관계가 명확하면 순위를 확정할 수 있음
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
