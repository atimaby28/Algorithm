package level1.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_예산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] d = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        int budget = Integer.parseInt(br.readLine());

        int result = solution(d, budget);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;


        return answer;
    }

}
