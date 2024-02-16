package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_행렬의덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];

        for (int i = 0; i < arr1.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arr2 = new int[n][m];

        for (int i = 0; i < arr2.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = solution(arr1, arr2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }


    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

}
