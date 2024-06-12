package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_석유시추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][m];

        for (int i = 0; i < land.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(land);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] land) {
        int answer = 0;



        return answer;
    }

}
/*
5 8
0 0 0 1 1 1 0 0
0 0 0 0 1 1 0 0
1 1 0 0 0 1 1 0
1 1 1 0 0 0 0 0
1 1 1 0 0 0 1 1
 */