package level2.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_두큐합같게만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] queue1 = new int[p];
        int[] queue2 = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < queue1.length; i++) {
            queue1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < queue2.length; i++) {
            queue2[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(queue1, queue2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            que1.offer(queue1[i]);
            sum2 += queue2[i];
            que2.offer(queue2[i]);
        }

        while (sum1 != sum2) {

            if(que1.isEmpty() || que2.isEmpty() || 500_000 < answer) {
                answer = -1;
                break;
            }

            if(sum1 > sum2) {
                int que1Ele = que1.poll();
                sum1 -= que1Ele;
                sum2 += que1Ele;
                que2.offer(que1Ele);
            } else if(sum1 < sum2) {
                int que2Ele = que2.poll();
                sum1 += que2Ele;
                sum2 -= que2Ele;
                que1.offer(que2Ele);
            } else {
                break;
            }

            answer++;

        }

        return answer;
    }
}
