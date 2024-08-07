package level2.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_숫자블록 {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long begin = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int[] result = solution(begin, end);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(long begin, long end) {
        int[] answer = {};

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                arrayList.add(0);
                continue;
            } else {
                arrayList.add((int) block(i));
            }
        }

        answer = arrayList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private static long block(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                arrayList.add(i);
                if (n / i <= 10_000_000) {
                    return n / i;
                }
            }
        }

        if (!arrayList.isEmpty()) {
            return arrayList.getLast();
        }

        return 1;
    }

}
