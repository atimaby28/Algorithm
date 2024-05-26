package level2.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_level2_우박수열정적분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        int r = Integer.parseInt(br.readLine());
        int[][] range = new int[r][2];

        for (int i = 0; i < range.length; i++) {
            st = new StringTokenizer(br.readLine());

            range[i][0] = Integer.parseInt(st.nextToken());
            range[i][1] = Integer.parseInt(st.nextToken());

        }

        double[] result = solution(k, range);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (k != 1) {
            arrayList.add(k);

            if (k % 2 != 0) {
                k = k * 3 + 1;
            } else {
                k = k / 2;
            }

            if (k == 1) {
                arrayList.add(k);
                break;
            }
        }

        int n = arrayList.size() - 1;
        double[] surface = new double[n];

        for (int i = 0; i < ranges.length; i++) {
//            반례...
//            if (ranges[i][0] == 0 && ranges[i][1] == 0) {
//                ranges[i][1] = n;
//            } else if (ranges[i][1] < 0) {
//
//            }
            ranges[i][1] = n + ranges[i][1];

            System.out.println(ranges[i][0] + " " + ranges[i][1]);

        }

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int startP = arrayList.get(i);
            int endP = arrayList.get(i + 1);

            surface[i] = Math.abs(endP - startP) / 2.0 + Math.min(startP, endP);
        }

        System.out.println(arrayList);

        for (int i = 0; i < surface.length; i++) {
            System.out.println(surface[i]);
        }

        System.out.println("==============");

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];

            if(start < end) {
                for (int j = start; j < end; j++) {
                    answer[i] += surface[j];
                }
            } else if(start == end) {
                answer[i] = 0.0;
            } else {
                answer[i] = -1.0;
            }

            System.out.println(answer[i]);
        }

        return answer;

    }
}

/*
5
4
0 0
0 -1
2 -3
3 -3
 */
