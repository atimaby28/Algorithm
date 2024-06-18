package level2.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level2_교점에별만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n][3];

        for (int i = 0; i < line.length; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
            line[i][2] = Integer.parseInt(st.nextToken());
        }

        String[] result = solution(line);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(int[][] line) {
        String[] answer = {};

        ArrayList<long[]> arrayList = new ArrayList<>();

        long xMax = Long.MIN_VALUE, yMax = Long.MIN_VALUE, xMin = Long.MAX_VALUE, yMin = Long.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];

                long adbc = a * d - b * c;
                if (adbc == 0) continue; //비교대상 직선과 평행함

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) continue; //x가 정수가 아님

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) continue; //y가 정수가 아님

                long x = bfed / adbc;
                long y = ecaf / adbc;

                xMax = Math.max(x, xMax);
                yMax = Math.max(y, yMax);
                xMin = Math.min(x, xMin);
                yMin = Math.min(y, yMin);

                arrayList.add(new long[]{x, y});

            }
        }

        int xLen = (int) (xMax - xMin) + 1;
        int yLen = (int) (yMax - yMin) + 1;

        answer = new String[yLen];

        for (int i = 0; i < yLen; i++) {
            answer[i] = ".".repeat(xLen);
        }

        for (long[] points : arrayList) {
            points[0] = points[0] - xMin;
            points[1] = yMax - points[1];

            System.out.println(points[0] + " " + points[1]);

            StringBuilder sb = new StringBuilder(answer[(int)points[1]]);

            sb.setCharAt((int)points[0], '*');

            answer[(int)points[1]] = sb.toString();

        }

        return answer;
    }

}

/*
5
2 -1 4
-2 -1 4
0 -1 1
5 -8 -12
5 8 12
 */