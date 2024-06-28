package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_아날로그시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());


        int result = solution(h1, m1, s1, h2, m2, s2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;



        return answer;
    }
}
