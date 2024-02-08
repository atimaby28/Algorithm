package level1.week1;

import java.io.*;

public class PG_level1_약수의합 {

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
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

//    public int sumDivisor(int num) {
//        int answer = 0;
//        for (int i = 1; i <= num / 2; i++) {
//            if (num % i == 0) {
//                answer += i;
//            }
//        }
//        return answer + num;
//    }

}
