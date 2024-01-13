package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_더크게합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b) {
        int answer = 0;

        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);

        if(Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) {
            answer = Integer.parseInt(s1 + s2);
        } else {
            answer = Integer.parseInt(s2 + s1);
        }

        return answer;
    }

}
