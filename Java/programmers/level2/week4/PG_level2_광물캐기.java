package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_광물캐기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] picks = new int[3];

        for (int i = 0; i < picks.length; i++) {
            st = new StringTokenizer(br.readLine());

            picks[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        String[] minerals = new String[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            minerals[i] = st.nextToken();
        }

        int result = solution(picks, minerals);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        

        return answer;
    }


}
