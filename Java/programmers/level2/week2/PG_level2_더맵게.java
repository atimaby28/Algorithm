package level2.week2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level2_더맵게 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] scoville = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < scoville.length; i++) {
            scoville[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        int result = solution(scoville, K);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while (true) {

            if(priorityQueue.isEmpty()) {
                return -1;
            }

            if(priorityQueue.peek() > K) {
                break;
            } else {
                int first = priorityQueue.poll();
                int second = priorityQueue.peek() * 2;

                priorityQueue.add(first + second);

                answer++;
            }
        }

        return answer;
    }

}
