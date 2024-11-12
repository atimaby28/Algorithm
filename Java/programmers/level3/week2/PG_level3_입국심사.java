package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(n, times);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        

        return answer;
    }

}
