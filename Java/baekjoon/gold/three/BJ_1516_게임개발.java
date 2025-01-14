package gold.three;

import java.io.*;
import java.util.*;

public class BJ_1516_게임개발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1]; // 각 건물의 건설 시간
        int[] indegree = new int[n + 1]; // 각 건물의 진입 차수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int prerequisite = Integer.parseInt(st.nextToken());
                if (prerequisite == -1) break;
                graph.get(prerequisite).add(i);
                indegree[i]++;
            }
        }

        String result = solution(n, time, indegree, graph);

        bw.write(result + "\n");

        bw.flush();
        
        bw.close();
        br.close();
    }

    public static String solution(int n, int[] time, int[] indegree, ArrayList<ArrayList<Integer>> graph) {
        StringBuilder sb = new StringBuilder();

        int[] result = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[current] + time[next]);
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        return sb.toString();
    }
}
