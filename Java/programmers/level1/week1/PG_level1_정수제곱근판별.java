package level1.week1;

import java.io.*;

public class PG_level1_정수제곱근판별 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        long result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(long n) {
        long answer = -1;

        long i = 1;
        while(i * i <= n) {
            if(i*i == n) {
                answer = (i + 1) * (i + 1);
                break;
            }
            i++;
        }

        return answer;
    }

}
