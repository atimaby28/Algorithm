import java.io.*;
import java.util.*;

public class PG_level3_가장먼노드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());  // 노드의 개수

        int[][] edge = new int[n + 1][2]; // 간선 배열 크기

        for (int i = 0; i < edge.length; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, edge);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();

        int[] levelArray = new int[n + 1];

        // graph에 연결 정보 채우기
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(1, graph, levelArray);

        // 최대 레벨을 가진 노드의 개수를 계산
        int maxLevel = Arrays.stream(levelArray).max().getAsInt();
        answer = (int) Arrays.stream(levelArray).filter(i -> i == maxLevel).count();

        return answer;
    }

    private static void bfs(int start, ArrayList<LinkedList<Integer>> graph, int[] levelArray) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        levelArray[start] = 1;  // 시작 노드 레벨 1로 설정

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer v : graph.get(current)) {
                if(levelArray[v] == 0) {
                    levelArray[v] = levelArray[current] + 1;
                    queue.offer(v);
                }
            }
        }
    }
}
