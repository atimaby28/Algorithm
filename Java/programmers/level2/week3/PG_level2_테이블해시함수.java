package level2.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_테이블해시함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] data = new int[n][m];

        for (int i = 0; i < data.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row_begin = Integer.parseInt(st.nextToken());
        int row_end = Integer.parseInt(st.nextToken());

        int result = solution(data, col, row_begin, row_end);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] != o2[col - 1]) {
                return Integer.compare(o1[col - 1], o2[col - 1]);
            } else {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        int xorSum = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int rowSum = 0;
            for (int j = 0; j < data[0].length; j++) {
                rowSum += data[i][j] % (i + 1);
            }
            xorSum = xorSum ^ rowSum;
        }

        answer = xorSum;

        return answer;
    }
}