package gold.one;

import java.io.*;

public class BJ_1300_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long result = solution(n, k);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    public static long solution(int n, int k) {
        long left = 1;
        long right = (long) n * n; // 가능한 값의 범위

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = countLessThanOrEqual(mid, n);

            // mid 이하의 값 개수가 k 이상이면 오른쪽 범위를 줄임
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left; // left가 B[k]가 됨
    }

    // mid 이하의 값이 몇 개인지 계산
    public static long countLessThanOrEqual(long mid, long N) {
        long count = 0;
        for (long i = 1; i <= N; i++) {
            count += Math.min(N, mid / i);
        }
        return count;
    }
}
