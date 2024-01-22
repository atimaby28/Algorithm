package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_수열과구간쿼리1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] queries = new int[p][q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(arr, queries);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];

        answer = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                answer[j]++;
            }
        }

        return answer;
    }

}
