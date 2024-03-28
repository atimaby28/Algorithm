package level2.week3;

import java.io.*;

public class PG_level2_삼각달팽이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];

        int[][] snail = new int[n][];

        for (int i = 0; i < snail.length; i++) {
            snail[i] = new int[i + 1];
        }

        snail[0][0] = 1;

        int cnt = n;
        int flag = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int a = 2; a <= answer.length; a++) {
            if(cnt-- > 1) {
                if(flag % 3 == 0) {
                    i += 1;
                } else if(flag % 3 == 1) {
                    j += 1;
                } else {
                    i -= 1;
                    j = snail[i].length - k;
                }
            } else {
                flag++;
                cnt = n--;
                a -= 1;
                if(flag % 3 == 2) {
                    k++;
                }
                continue;
            }
            snail[i][j] = a;
        }

        int s = 0;
        for (int l = 0; l < snail.length; l++) {
            for (int z = 0; z < snail[l].length; z++) {
                answer[s++] = snail[i][j];
            }
        }

        return answer;
    }

}
