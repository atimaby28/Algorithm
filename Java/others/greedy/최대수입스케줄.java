package greedy;

import java.io.*;
import java.util.*;

public class 최대수입스케줄 {

    static int n, max = Integer.MIN_VALUE;

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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Schedule> arrayList = new ArrayList<>();

        for (int[] schedule : list) {
            arrayList.add(new Schedule(schedule[0], schedule[1]));
            if (schedule[1] > max) max = schedule[1];
        }

        Collections.sort(arrayList);

        System.out.println(arrayList);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arrayList.get(j).limitDate < i) break;
                priorityQueue.offer(arrayList.get(j).income);
            }
            if (!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }
        return answer;
    }
}

class Schedule implements Comparable<Schedule> {
    int income, limitDate;

    Schedule(int income, int limitDay) {
        this.income = income;
        this.limitDate = limitDay;
    }

    @Override
    public int compareTo(Schedule s) {
        return Integer.compare(s.limitDate, this.limitDate);
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
