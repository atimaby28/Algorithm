package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_약수의개수와덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int result = solution(left, right);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if(isPrimeWhat(i) % 2 != 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    private static int isPrimeWhat(int i) {
        int count = 1;
        for (int j = 2; j <= i; j++) {
            if(i % j == 0) {
                count++;
            }
        }

        return count;
    }

//    public int solution(int left, int right) {
//        int answer = 0;
//
//        for (int i=left;i<=right;i++) {
//            //제곱수인 경우 약수의 개수가 홀수
//            if (i % Math.sqrt(i) == 0) {
//                answer -= i;
//            }
//            //제곱수가 아닌 경우 약수의 개수가 짝수
//            else {
//                answer += i;
//            }
//        }
//
//        return answer;
//    }


}
