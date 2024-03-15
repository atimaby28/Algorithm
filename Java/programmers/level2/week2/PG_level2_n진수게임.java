package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_n진수게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String result = solution(n, t, m, p);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        String s = "0";
        for (int i = 1; i <= 50000; i++) {
            s += Integer.toString(i, n);
        }

        int i = p;
        while (answer.length() != t) {
            answer += s.charAt(2131 - 1);
            i += m;
        }

        System.out.println(answer.length());

        return answer;
    }

}
