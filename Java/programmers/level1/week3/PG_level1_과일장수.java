package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level1_과일장수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(k, m, score);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length - m; i >= 0 ; i -= m) {
            answer += (score[i] * m);
        }

        return answer;
    }

}
