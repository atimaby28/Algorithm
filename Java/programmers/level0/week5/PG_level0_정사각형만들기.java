package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_정사각형만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[][] solution(int[][] arr) {
        int[][] answer = {};

        if(arr.length != arr[0].length) {
            if(arr.length > arr[0].length) {
                answer = new int[arr.length][arr[0].length + (arr.length - arr[0].length)];
            } else {
                answer = new int[arr.length + (arr[0].length - arr.length)][arr[0].length];
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else {
            answer = arr;
        }

        return answer;
    }

}
