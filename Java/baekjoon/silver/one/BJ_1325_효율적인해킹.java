package silver.one;

import java.io.*;
import java.util.*;

public class BJ_1325_효율적인해킹 {

    static boolean[] visited;
    static int[] reliableComputer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // node
        int m = Integer.parseInt(st.nextToken()); // edge

        ArrayList<LinkedList<Integer>> computerInfo = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            computerInfo.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            computerInfo.get(start).add(end);
        }

        String result = solution(computerInfo, n);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();

    }

    private static String solution(ArrayList<LinkedList<Integer>> computerInfo, int n) {
        StringBuilder sb = new StringBuilder();

        reliableComputer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(computerInfo, i);
        }

        int max = -1;

        for (int i = 1; i < reliableComputer.length; i++) {
            max = Math.max(max, reliableComputer[i]);
        }

        for (int i = 1; i < reliableComputer.length; i++) {
            if(max == reliableComputer[i]) {
                sb.append(i).append(" ");
            }
        }

        return sb.toString();
    }

    private static void bfs(ArrayList<LinkedList<Integer>> computerInfo, int startComputer) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(startComputer);
        visited[startComputer] = true;

        while (!queue.isEmpty()) {
            int computer = queue.poll();

            for (Integer k : computerInfo.get(computer)) {
                if(!visited[k]) {
                    visited[k] = true;
                    reliableComputer[k]++;
                    queue.offer(k);
                }
            }
        }
    }
}
