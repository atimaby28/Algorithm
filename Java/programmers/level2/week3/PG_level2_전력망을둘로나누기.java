package level2.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_level2_전력망을둘로나누기 {

    private static ArrayList<Integer>[] adjList;
    private static int N, answer;

    public static int[][] wires;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Node

        // graph에 연결 정보 채우기
        wires = new int[n - 1][2];
        visited = new boolean[n + 1];

        for (int i = 0; i < wires.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < wires[i].length; j++) {
                wires[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(n, wires);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;

        // ❶ 전선의 연결 정보를 저장할 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // ❷ 전선의 연결 정보를 인접 리스트에 저장
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];

        // ❸ 깊이 우선 탐색 시작
        dfs(1);

        return answer;
    }

    private static int dfs(int now) {
        visited[now] = true;

        // ❹ 자식 노드의 수를 저장하고 반환할 변수 선언
        int sum = 0;
        // ❺ 연결된 모든 전선을 확인
        for (int next : adjList[now]) {
            if (!visited[next]) {
                // ❻ (전체 노드 - 자식 트리의 노드 수) - (자식 트리의 노드 수) 의 절대값이 가장 작은 값을 구함
                int cnt = dfs(next); // 자식 트리가 가진 노드의 수
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                // ❼ 자식 노드의 수를 더함
                sum += cnt;
            }
        }

        // ❽ 전체 자식 노드의 수에 1(현재 now 노드)을 더해서 반환
         return sum + 1;
    }
}

//9
//1 3
//2 3
//3 4
//4 5
//4 6
//4 7
//7 8
//7 9
