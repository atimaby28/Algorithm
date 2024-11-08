package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_디스크컨트롤러 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] jobs = new int[p][q];

        for (int i = 0; i < jobs.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < jobs[0].length; j++) {
                jobs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(jobs);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        

        return answer;
    }

}
