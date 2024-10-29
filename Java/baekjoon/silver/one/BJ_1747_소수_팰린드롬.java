package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1747_소수_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int n) {
        int answer = 0;

        return answer;
    }
}
