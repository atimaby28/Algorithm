package level2.week1;

import java.io.*;

public class PG_level1_숫자의표현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            int sum = 0;
            int start = i;
            while(sum < n) {
                sum += start++;
            }
            if(sum == n) {
                answer++;
            }
        }

        return answer;
    }

}
