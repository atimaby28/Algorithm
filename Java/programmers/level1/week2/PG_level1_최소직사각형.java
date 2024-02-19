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

        for (int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }

        int max1 = sizes[0][0];
        int max2 = sizes[0][1];
        for (int i = 0; i < sizes.length - 1; i++) {
            if(max1 < sizes[i + 1][0]) {
                max1 = sizes[i + 1][0];
            }

            if(max2 < sizes[i + 1][1]) {
                max2 = sizes[i + 1][1];
            }
        }

        answer = max1 * max2;

        return answer;
    }

//    public int solution(int[][] sizes) {
//        int length = 0, height = 0;
//        for (int[] card : sizes) {
//            length = Math.max(length, Math.max(card[0], card[1]));
//            height = Math.max(height, Math.min(card[0], card[1]));
//        }
//        int answer = length * height;
//        return answer;
//    }

}
