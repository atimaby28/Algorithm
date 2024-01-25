package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_간단한논리연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean x1 = Boolean.parseBoolean(st.nextToken());
        boolean x2 = Boolean.parseBoolean(st.nextToken());
        boolean x3 = Boolean.parseBoolean(st.nextToken());
        boolean x4 = Boolean.parseBoolean(st.nextToken());

        boolean result = solution(x1, x2, x3, x4);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;

        answer = (x1 | x2) & (x3 | x4);

        return answer;
    }

}
