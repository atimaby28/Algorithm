package greedy;

import java.io.*;
import java.util.*;

public class 최대수입스케줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }


        int result = solution(list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[][] list) {
        int answer = 0;

        PriorityQueue<Schedule> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] schedule : list) {
            priorityQueue.offer(new Schedule(schedule[0], schedule[1]));
        }

        for (Schedule schedule : priorityQueue) {
            answer += schedule.income;
            System.out.println(schedule.income + " "  + schedule.limitDate);
        }


        return answer;
    }
}

class Schedule implements Comparable<Schedule>{
    int income, limitDate;

    Schedule(int income, int limitDay) {
        this.income = income;
        this.limitDate = limitDay;
    }

    @Override
    public int compareTo(Schedule s) {
        return Integer.compare(this.limitDate, s.limitDate);
    }

}
/*
6
50 2
20 1
40 2
60 3
30 3
30 1

반례

10
13 2
18 1
68 10
72 8
11 7
41 2
48 7
15 7
34 1
13 8

= 302
 */
