package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_신고결과받기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] id_list = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < id_list.length; i++) {
            id_list[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] report = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < report.length; i++) {
            report[i] = st.nextToken();
        }

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(id_list, report, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};



        return answer;
    }

}
