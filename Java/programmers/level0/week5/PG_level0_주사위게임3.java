package level0.week5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level0_주사위게임3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int result = solution(a, b, c, d);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b, int c, int d) {
        int answer = 0;

        int[] check = new int[7];
        int[][] diff = new int[5][7];

        check[a]++;
        check[b]++;
        check[c]++;
        check[d]++;

        for (int i = 0; i < check.length; i++) {
            if(check[i] != 0) {
            }
        }



        return answer;
    }

}
