package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_최소직사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] sizes = new int[m][n];

        for (int i = 0; i < sizes.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sizes[i].length; j++) {
                sizes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(sizes);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] sizes) {
        int answer = 0;


        


        return answer;
    }

}
