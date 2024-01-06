package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자열붙여서출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        bw.write(a + b + "\n");

        bw.flush();
        bw.close();
    }
}
