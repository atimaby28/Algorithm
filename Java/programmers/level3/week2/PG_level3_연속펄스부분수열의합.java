package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_연속펄스부분수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(sequence);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static long solution(int[] sequence) {
        int n = sequence.length;

        // 두 개의 펄스 수열을 곱한 결과
        long[] pulse1 = new long[n]; // [1, -1, 1, -1, ...]을 곱한 결과
        long[] pulse2 = new long[n]; // [-1, 1, -1, 1, ...]을 곱한 결과

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pulse1[i] = sequence[i];   // 1을 곱한 것과 동일
                pulse2[i] = -sequence[i]; // -1을 곱한 것과 동일
            } else {
                pulse1[i] = -sequence[i]; // -1을 곱한 것과 동일
                pulse2[i] = sequence[i];  // 1을 곱한 것과 동일
            }
        }

        // 카데인 알고리즘으로 최대 연속 부분 합 계산
        long maxSum1 = kadane(pulse1);
        long maxSum2 = kadane(pulse2);

        // 두 결과 중 최댓값 반환
        return Math.max(maxSum1, maxSum2);
    }

    private static long kadane(long[] arr) {
        long maxSum = Long.MIN_VALUE; // 초기값은 음의 무한대
        long currentSum = 0;

        for (long num : arr) {
            currentSum = Math.max(num, currentSum + num); // 현재 값을 포함하거나 새로 시작
            maxSum = Math.max(maxSum, currentSum);       // 최댓값 갱신
        }

        return maxSum;
    }
}
