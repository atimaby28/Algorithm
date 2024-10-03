package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_보석쇼핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        String[] gems = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gems.length; i++) {
            gems[i] = st.nextToken();
        }

        int[] result = solution(gems);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String[] gems) {
        int[] answer = {};



        return answer;
    }

}
