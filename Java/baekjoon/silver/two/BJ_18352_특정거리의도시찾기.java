package silver.two;

import java.io.*;
import java.util.*;

public class BJ_18352_특정거리의도시찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityNum = Integer.parseInt(st.nextToken());
        int roadNum = Integer.parseInt(st.nextToken());
        int shortestDist = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());

        ArrayList<LinkedList<Integer>> roadInfo = new ArrayList<>();

        for (int i = 0; i <= cityNum; i++) {
            roadInfo.add(new LinkedList<>());
        }

        for (int i = 0; i < roadNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            roadInfo.get(start).add(end);
        }

        String result = solution(roadInfo, cityNum, startCity, shortestDist);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();

    }

    private static String solution(ArrayList<LinkedList<Integer>> roadInfo, int cityNum, int startCity, int shortestDist) {
        StringBuilder sb = new StringBuilder();

        int[] distance = new int[cityNum + 1];
        Arrays.fill(distance, -1); // -1로 초기화 (방문하지 않은 도시)

        bfs(roadInfo, startCity, shortestDist, distance);

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] == shortestDist) {
                sb.append(i).append("\n");
            }
        }

        if(sb.isEmpty()) {
            sb.append("-1");
        }

        return sb.toString();
    }

    private static void bfs(ArrayList<LinkedList<Integer>> roadInfo, int startCity, int shortestDist, int[] distance) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(startCity);
        distance[startCity] = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int nextCity : roadInfo.get(city)) {
                if(distance[nextCity] == -1) {
                    distance[nextCity] = distance[city] + 1;
                    queue.offer(nextCity);
                }
            }
        }
    }
}
