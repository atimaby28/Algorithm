package gold.four;

import java.io.*;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기 {
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
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
        }

        while (pq.size() != 1) {
            int data1 = pq.poll();
            int data2 = pq.poll();

            answer += data1 + data2;

            pq.offer(data1 + data2);
        }

        return answer;
    }
}
