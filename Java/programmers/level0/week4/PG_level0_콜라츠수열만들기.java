package level0.week4;

import java.io.*;
import java.util.Arrays;

public class PG_level0_콜라츠수열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n) {
        int[] answer = {};

        while(n != 1) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = n;

            if(n >= 1) {
                break;
            } else if(n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
        }

        return answer;
    }

}
