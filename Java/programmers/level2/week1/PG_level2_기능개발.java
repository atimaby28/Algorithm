package level2.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_기능개발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] progresses = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] speeds = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(progresses, speeds);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0;
            for (int j = progresses[i]; j < 100; j += speeds[i]) {
                cnt++;
            }
            queue.add(cnt);
        }

        while (!queue.isEmpty()) {
            int day = queue.poll();

            int days = 1;
            while (!queue.isEmpty() && day >= queue.peek()) {
                days++;
                queue.poll();
            }
            arrayList.add(days);
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

}
