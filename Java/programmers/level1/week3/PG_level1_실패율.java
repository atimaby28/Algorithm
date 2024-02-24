package level1.week3;

import java.io.*;
import java.util.*;

public class PG_level1_실패율 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        int[] stages = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stages.length; i++) {
            stages[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(N, stages);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] pStage = new int[502];
        double[][] data = new double[N][2];

        for (int i = 0; i < stages.length; i++) {
            pStage[stages[i]]++;
        }

        int challenger = stages.length;
        for (int i = 0; i < N; i++) {

            data[i][0] = pStage[i + 1] / (double) (challenger - pStage[i]);
            data[i][1] = i + 1;
            challenger -= pStage[i];

        }

        Arrays.sort(data, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) data[i][1];
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

}
