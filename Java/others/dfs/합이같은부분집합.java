package dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 합이같은부분집합 {

    public static boolean[] visited;
    public static boolean answer = false;

    public static void main(String[] args) throws IOException {

        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Node

        visited = new boolean[n];

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // DFS_Array_Graph
        dfs(array, 0, 0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();

    }

    private static void dfs(int[] array, int sum, int idx) {
        if(idx == visited.length) {
            int group1 = 0;
            int group2 = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    group1 += array[i];
                } else {
                    group2 += array[i];
                }
            }

            if (group1 == group2) {
                for (int i = 0; i < visited.length; i++) {
                    System.out.print(visited[i] + " ");
                }
                answer = true;
                System.out.println();
            }

            return;

        }

        // 현재 요소를 방문하지 않은 경우
        if (!visited[idx]) {
            visited[idx] = true;

            // 현재 요소를 포함하는 경우
            dfs(array, sum + array[idx], idx + 1);

            // 현재 요소를 포함하지 않는 경우
            visited[idx] = false;
        }

        // 현재 요소를 포함하지 않는 경우
        dfs(array, sum, idx + 1);

    }


}