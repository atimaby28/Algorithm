package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_기둥과보설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        int[][] build_frame = new int[k][4];

        for (int i = 0; i < build_frame.length; i++) {
            st = new StringTokenizer(br.readLine());
            build_frame[i][0] = Integer.parseInt(st.nextToken());
            build_frame[i][1] = Integer.parseInt(st.nextToken());
            build_frame[i][2] = Integer.parseInt(st.nextToken());
            build_frame[i][3] = Integer.parseInt(st.nextToken());
        }

        int[][] result = solution(n, build_frame);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        

        return answer;
    }

}
