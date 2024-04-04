package twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class 연속된자연수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int n) {
        int answer = 0;

        int[] sequence = new int[n];

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = i + 1;
        }

        int lt = 0, rt = 0;

        int sum = 0;
        while (lt < sequence.length && rt < sequence.length) {
            if(sum < n) {
                sum += sequence[rt++];
            } else {
                sum -= sequence[lt++];
            }

            if(sum == n) {
                answer++;
            }
        }

        return answer;
    }

}
