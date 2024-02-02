package level0.week5;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class PG_level0_두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        String result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String a, String b) {
        String answer = "";

        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);

        answer = bigA.add(bigB).toString();

        return answer;
    }

}
