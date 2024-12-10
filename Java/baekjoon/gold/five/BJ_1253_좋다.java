package gold.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] good = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < good.length; i++) {
            good[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(good);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int solution(int[] good) {
        int answer = 0;

        return answer;
    }


}
