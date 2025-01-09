package gold.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1976_여행가자 {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] connection = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                connection[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String plan = br.readLine();

        String result = solution(connection, m, plan);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int[][] connection, int m, String plan) {
        String answer = "YES";

        int n = connection.length - 1;

        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(connection[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        String[] village = plan.split(" ");

        for (int i = 0; i < m - 1; i++) {
            int x = find(Integer.parseInt(village[i]));
            int y = find(Integer.parseInt(village[i + 1]));

            if(x != y) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            unf[y] = x;
        }
    }

    private static int find(int x) {
        if(x == unf[x]) {
            return x;
        } else {
            return unf[x] = find(unf[x]);
        }
    }
}
