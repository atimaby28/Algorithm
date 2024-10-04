package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_징검다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] stones = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stones.length; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(stones, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;

        return answer;
    }

}
