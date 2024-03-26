package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_쿼드압축후개수세기 {

    public static int result[] = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[k][k];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        quardZip(arr, 0, 0, arr.length);

        answer[0] = result[0];
        answer[1] = result[1];

        return answer;
    }

    private static void quardZip(int[][] arr, int x, int y, int length) {
        if(checkQuard(arr, x, y, length, arr[x][y])) {
            if(arr[x][y] == 1) {
                result[1]++;
            } else {
                result[0]++;
            }

            return;

        }

        quardZip(arr, x, y, length / 2); // 좌상
        quardZip(arr, x + length / 2, y, length / 2); // 우상
        quardZip(arr, x, y + length / 2, length / 2); // 좌하
        quardZip(arr, x + length / 2, y + length / 2, length / 2); // 우하
    }

    private static boolean checkQuard(int[][] arr, int x, int y, int length, int val) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if(arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

}
