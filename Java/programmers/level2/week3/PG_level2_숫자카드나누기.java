package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_숫자카드나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arrayA = new int[k];
        int[] arrayB = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(arrayA, arrayB);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        return answer;
    }
}
