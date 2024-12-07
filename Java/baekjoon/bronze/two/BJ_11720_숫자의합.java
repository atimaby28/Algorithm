package bronze.two;

import java.io.*;
public class BJ_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int result = solution(num);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(String num) {
        int answer = 0;

        answer = num.chars().map(c -> c - '0').sum();

        return answer;
    }
}
