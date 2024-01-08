package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_flag에따라다른값반환하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean flag = Boolean.parseBoolean(st.nextToken());

        int result = solution(a, b, flag);

        bw.write(a + b + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b, boolean flag) {
        int answer = 0;

        if(flag) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }

}
