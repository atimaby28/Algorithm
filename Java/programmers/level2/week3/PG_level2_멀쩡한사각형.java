package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_멀쩡한사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        long result = solution(w, h);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static long solution(int w, int h) {
        long answer = 1;

        

        return answer;
    }

}
