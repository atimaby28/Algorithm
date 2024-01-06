package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = solution(number, n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int number, int n, int m) {
        int answer = 0;

        int gcd = getLCM(n, m);

        System.out.println(gcd);

        answer = number % gcd == 0? 1: 0;

        return answer;
    }

    public static int getGcd(int n, int m) {

        if(m == 0) {
            return n;
        }

        return getGcd(m, n % m);

    }

    public static int getLCM(int n, int m) {
        return n * m / getGcd(n, m);
    }

}
