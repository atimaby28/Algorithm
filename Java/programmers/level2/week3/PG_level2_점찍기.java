package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_점찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        long result = solution(k, d);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(int k, int d) {
        long answer = 0;

        int x = 0;
        while (k * x < d) {
            x++;
        }

        answer += x * 2 + 1;



        return answer;
    }

}
