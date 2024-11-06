package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_여행경로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[][] tickets = new String[p][q];

        for (int i = 0; i < tickets.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < tickets[0].length; j++) {
                tickets[i][j] = st.nextToken();
            }
        }

        String[] result = solution(tickets);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        

        return answer;
    }

}
