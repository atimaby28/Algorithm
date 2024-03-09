package level2.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_행렬의곱셈 {

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

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[p][q];

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
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
            System.out.println();
        }

        return answer;
    }

}

//3 2
//        1 4
//        3 2
//        4 1
//        2 2
//        3 3
//        3 3