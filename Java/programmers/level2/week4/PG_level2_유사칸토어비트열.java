package level2.week4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level2_유사칸토어비트열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        int result = solution(n, l, r);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public int solution(int n, long l, long r) {
        int answer = 0;

        long cntR = getOneCount(n, r, 0); // r까지 1의 개수
        long cntPrevL = getOneCount(n, l - 1, 0); // l-1까지 1의 개수

        answer = (int) (cntR - cntPrevL);

        return answer;
    }

    public long getOneCount(int n, long target, long sum) {
        if (n == 1) {
            if (target <= 2)
                return sum + target;
            else
                return sum + target - 1;
        }

        long q = target / (long) (Math.pow(5, n - 1));
        long r = target % (long) (Math.pow(5, n - 1));

        if (q <= 2)
            sum += (long) (Math.pow(4, n - 1)) * q;
        else
            sum += (long) (Math.pow(4, n - 1)) * (q - 1);

        if (q == 2 || r == 0) return sum;

        return getOneCount(n - 1, r, sum);
    }


}
