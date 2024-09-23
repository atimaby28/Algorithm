package level3.week1;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level3_야근지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        int[] works = new int[k];

        for (int i = 0; i < k; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(k, works);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works) {
            pq.offer(work);
        }

        for(int i = 0; i < n; i++) {

            if(pq.peek() == 0) continue;

            pq.offer(pq.poll() - 1);
        }

        while(pq.iterator().hasNext()) {
            answer += Math.pow(pq.poll(), 2);
        }

//        answer = pq.stream().mapToInt(k -> k * k).sum();

        return answer;
    }
}
