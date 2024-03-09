package level2.week1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level2_HIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] citations = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < citations.length; i++) {
            citations[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(citations);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] citations) {
        int answer = 0;

        int[][] hIndex = new int[citations.length][3];

        for (int i = 0; i < citations.length; i++) {

            int h = citations[i];

            int more = 0;

            for (int j = 0; j < citations.length; j++) {

                if (h <= citations[j]) {
                    more++;
                }
            }

            hIndex[i][0] = h;
            hIndex[i][1] = more;

            hIndex[i][2] = Math.min(h, more);

        }

        Arrays.sort(hIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] > o2[2]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        answer = hIndex[0][2];

        return answer;
    }

}
