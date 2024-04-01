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
        int answer = -2;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            que1.offer(queue1[i]);
            sum2 += queue2[i];
            que2.offer(queue2[i]);
        }

        int target = (sum1 + sum2) / 2;

        int cnt = 0;
        while(sum1 != sum2) {

            if(sum1 > target) {
                int num = que1.poll();
                que2.offer(num);
                sum1 -= num;
                sum2 += num;
            } else if(sum1 < target) {
                int num = que2.poll();
                que1.offer(num);
                sum1 += num;
                sum2 -= num;
            }

            if(cnt > queue1.length + queue2.length + 1) {
                cnt = -1;
                break;
            }

            cnt++;

        }

        answer = cnt;

        return answer;
    }
}
