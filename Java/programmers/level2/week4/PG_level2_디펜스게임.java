package level2.week4;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level2_디펜스게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int e = Integer.parseInt(br.readLine());

        int[] enemy = new int[e];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            enemy[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, k, enemy);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int soldier = n;
        int card = k;

        for (int i = 0; i < enemy.length; i++) {
            soldier -= enemy[i];
            priorityQueue.add(enemy[i]);

            if (soldier < 0) {
                if (card > 0 && !priorityQueue.isEmpty()) {
                    soldier += priorityQueue.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
