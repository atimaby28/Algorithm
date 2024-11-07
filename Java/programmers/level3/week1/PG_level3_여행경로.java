package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_여행경로 {

    static boolean[] visited;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[][] tickets = new String[p][q];

        for (int i = 0; i < tickets.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < tickets[0].length; j++) {
                tickets[i][j] = st.nextToken();
            }
        }

        String[] result = solution(tickets);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];

        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(list);

        answer = list.get(0).split(" ");

        return answer;
    }

    private static void dfs(String departure, String route, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            // System.out.println(route);
            list.add(route);

            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && departure.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }

    // bfs 풀이
    /*
    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        // Graph를 생성합니다.
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // 모든 티켓 정보를 graph에 추가합니다.
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        answer = bfs(graph, "ICN");

        return answer;
    }

    private static String[] bfs(Map<String, PriorityQueue<String>> graph, String from) {
        LinkedList<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        stack.push(from);

        while (!stack.isEmpty()) {
            String airport = stack.peek();

            // 현재 공항에서 갈 수 있는 경로가 있는지 확인합니다.
            if (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
                // 우선순위가 높은 경로를 선택하여 이동합니다.
                stack.push(graph.get(airport).poll());
            } else {
                // 더 이상 갈 곳이 없으면 경로를 route에 추가합니다.
                route.addFirst(stack.pop());
            }
        }

        return route.toArray(new String[0]);
    }
    */
}
