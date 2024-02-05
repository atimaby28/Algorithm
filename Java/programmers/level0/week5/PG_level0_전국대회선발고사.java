package level0.week5;

import java.io.*;
import java.util.*;

public class PG_level0_전국대회선발고사 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] rank = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rank.length; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        boolean[] attendance = new boolean[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < attendance.length; i++) {
            attendance[i] = Boolean.parseBoolean(st.nextToken());
        }

        int result = solution(rank, attendance);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] rank, boolean[] attendance) {
        int answer = 0;

        Map<Integer, Integer> hsmp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < rank.length; i++) {
            if(attendance[i] == true) {
                hsmp.put(rank[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hsmp.entrySet()) {
            pq.add(entry.getKey());
        }

        answer = hsmp.get(pq.poll()) * 10000 + hsmp.get(pq.poll()) * 100 + hsmp.get(pq.poll());

        return answer;
    }

}
