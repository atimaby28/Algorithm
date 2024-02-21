package level1.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_콜라문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int result = solution(a, b, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n > 0) {
            int spare = 0;
            if(n / a != 0) {
                spare = n % a;
            }

            answer += n / a;

            n = (n / a ) + spare;
        }

        return answer;
    }

}
