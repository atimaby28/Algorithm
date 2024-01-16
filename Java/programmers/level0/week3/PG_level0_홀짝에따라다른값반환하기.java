package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_홀짝에따라다른값반환하기 {

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

        answer = oddEven(n);

        return answer;
    }

    private static int oddEven(int n) {
        if(n < 0) {
            return 0;
        }

        if(n % 2 != 0) {
            return oddEven(n - 2) + n;
        } else {
            return oddEven(n - 2) + (n * n) ;
        }
    }

}
