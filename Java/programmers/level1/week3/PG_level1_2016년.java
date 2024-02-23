package level1.week3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PG_level1_2016년 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int a, int b) {
        String answer = "";

        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int[] cal = new int[12];

        cal[0] = 31;
        cal[1] = 29;
        cal[2] = 31;
        cal[3] = 30;
        cal[4] = 31;
        cal[5] = 30;
        cal[6] = 31;
        cal[7] = 31;
        cal[8] = 30;
        cal[9] = 31;
        cal[10] = 30;
        cal[11] = 31;

        int days = b;
        for (int i = 0; i < a - 1; i++) {
            days += cal[i];
        }

        answer = dayOfWeek[days % 7];

        return answer;
    }

}
