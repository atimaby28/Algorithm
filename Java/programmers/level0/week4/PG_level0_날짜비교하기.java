package level0.week4;

import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class PG_level0_날짜비교하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] date1 = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < date1.length; i++) {
            date1[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] date2 = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < date2.length; i++) {
            date2[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(date1, date2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] date1, int[] date2) {
        int answer = 0;

        LocalDate dateA = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate dateB = LocalDate.of(date2[0], date2[1], date2[2]);

        if(dateA.isBefore(dateB)) {
            answer = 1;
        }

        return answer;
    }

}
