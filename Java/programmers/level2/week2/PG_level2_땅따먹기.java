package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_땅따먹기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] land = new int[p][q];

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

        for (int i = 0; i < land.length  - 1; i++) {
            int max = -1;
            int idx = -1;
            for (int j = 0; j < land[i].length; j++) {
                if(land[i][j] > max) {
                    max = land[i][j];
                    idx = j;
                }
            }

            System.out.println(max + " " + idx);

            for (int j = 0; j < land[i].length; j++) {
                if(idx == j) {
                    continue;
                }
                land[i + 1][j] = max + land[i + 1][j];
            }
        }

        for (int j = 0; j < land[0].length; j++) {
            if(answer < land[land.length - 1][j]){
                answer = land[land.length - 1][j];
            }
        }

        return answer;
    }

}
