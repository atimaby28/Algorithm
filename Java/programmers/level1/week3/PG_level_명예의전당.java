package level1.week3;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level_명예의전당 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(k, score);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {

            if(pq.size() < k) {
                pq.add(score[i]);
            } else if(pq.peek() < score[i]){
                pq.poll();
                pq.add(score[i]);
            }

            answer[i] = pq.peek();

        }

        return answer;
    }

}
