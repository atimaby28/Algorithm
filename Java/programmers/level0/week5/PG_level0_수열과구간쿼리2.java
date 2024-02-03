package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_수열과구간쿼리2 {
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

        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
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
        int[] answer = {};

        for (int i = 0; i < queries.length; i++) {
            int[] temp = {};
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    temp = Arrays.copyOf(temp, temp.length + 1);
                    temp[temp.length - 1] = arr[j];
                }
            }

            if (temp.length != 0) {
                Arrays.sort(temp);
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = temp[0];
            } else {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = -1;
            }

        }

        return answer;
    }

}
