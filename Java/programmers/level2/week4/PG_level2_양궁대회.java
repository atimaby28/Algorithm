package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_양궁대회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] info = new int[11];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < info.length; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(n, info);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {};

        if(n == 1) {
            answer = new int[]{-1};
        } else {
            answer = new int[11];
        }

        while (n > 0) {

        }

        return answer;
    }

}
