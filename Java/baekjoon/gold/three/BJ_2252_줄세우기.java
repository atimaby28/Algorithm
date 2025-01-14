package gold.three;

import java.io.*;
import java.util.*;

public class BJ_2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> students = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            students.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            students.get(s).add(e);
            indegree[e]++;
        }

        String result = solution(students, indegree);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(List<List<Integer>> students, int[] indegree) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            sb.append(now).append(" ");

            for (int next : students.get(now)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return sb.toString().trim();
    }
}
