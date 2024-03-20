package level2.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level2_주식가격 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int[] prices) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[i] <= prices[j]) {
                    count++;
                } else {
                    count += 1;
                    break;
                }
            }

            queue.add(count);
        }

        answer = new int[queue.size()];

        int i = 0;
        while (!queue.isEmpty()) {
            answer[i++] = queue.poll();
        }

        return answer;
    }

}
