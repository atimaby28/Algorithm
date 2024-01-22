package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_배열만들기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] intervals = new int[m][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                intervals[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(arr, intervals);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[(intervals[0][1] - intervals[0][0]) + 1 + (intervals[1][1] - intervals[1][0]) + 1];

        int x = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer[x++] = arr[j];
            }
        }

        return answer;
    }

}
