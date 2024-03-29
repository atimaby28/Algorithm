package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지찾기 {
    public static int ans = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int result = solution(s, e);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int s, int e) {
        int answer = 0;

        visited = new boolean[10001];

        bfs(s, e);

        answer = ans;

        return answer;
    }

    private static void bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        boolean flag = false;
        while (!queue.isEmpty()) {
            int len = queue.size();

            ans++;

            for (int i = 0; i < len; i++) {
                int idx = queue.poll();

                if(idx + 1 == e || idx - 1 == e || idx + 5 == e) {
                    flag = true;
                    break;
                }

                if(idx >= 1 && idx < 10000 && !visited[idx]) {
                    queue.add(idx + 1);
                    queue.add(idx - 1);
                    queue.add(idx + 5);
                }

                visited[idx] = true;
            }

            if(flag) {
                break;
            }

        }
    }
}
