package level1.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_x만큼간격이있는n개의숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] result = solution(x, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long[] solution(int x, int n) {
        long[] answer = {};

        // 변수 i를 long으로 설정해야 한다.
        for (long i = x; 0 < n--; i += x) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = i;
        }

        return answer;
    }

}
