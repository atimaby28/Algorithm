package gold.four;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int result = solution(array);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int[] array) {
        int answer = 0;

        // 정수를 음수와 양수로 나누어 저장
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        int oneCount = 0; // 값이 '1'인 경우 곱하면 '1'이지만, 더하면 '2'이기 때문에 따로 처리
        int zeroCount = 0; // 값이 '0'인 경우 음수와 곱하면 '0'이지만, 더하면 '-1'이기 때문에 따로 처리


        for (int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                minusPQ.offer(array[i]);
            } else if(array[i] > 0 && array[i] != 1) {
                plusPQ.offer(array[i]);
            } else if(array[i] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        while (minusPQ.size() >= 2) {
            int a = minusPQ.poll();
            int b = minusPQ.poll();

            answer += a * b;
        }

        while (plusPQ.size() >= 2) {
            int a = plusPQ.poll();
            int b = plusPQ.poll();

            answer += a * b;
        }

        if(!minusPQ.isEmpty() && zeroCount == 0) {
            answer += minusPQ.poll();
        }

        if(!plusPQ.isEmpty()) {
            answer += plusPQ.poll();
        }

        answer += oneCount;

        return answer;
    }

}
