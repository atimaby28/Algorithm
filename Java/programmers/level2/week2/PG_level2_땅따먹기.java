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

        for (int i = 0; i < land.length - 1; i++) {
            int[] init = Arrays.copyOf(land[i + 1], land.length + 1);
            int idx = 0;
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if(j == k) {
                        continue;
                    }
                    max = Math.max(max, land[i][j] + land[i + 1][k]);
                }
                System.out.println(max);
            }

            for (int k = 1; k < init.length; k++) {
                if(init[k - 1] < init[k]) {
                    idx = k;
                }
            }
            land[i + 1][idx] = init[idx];
        }

        for (int i = 0; i < land[land.length - 1].length; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }

}
