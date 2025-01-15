package platinum.five;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1219_오민식의고민 {

    static long[] cityProfit;
    static long[] distance;
    static List<City> cites;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken()); // node
        int s = Integer.parseInt(st.nextToken()); // edge
        int e = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        cites = new ArrayList<>();
        distance = new long[node];
        cityProfit = new long[node];

        Arrays.fill(distance, Long.MIN_VALUE);

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cites.add(new City(u, v, w));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityProfit.length; i++) {
            cityProfit[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(node, s, e);

        bw.write(result);

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int node, int s, int e) {
        String answer = "";

        answer = bellmanford(node, s, e);

        return answer;
    }

    private static String bellmanford(int node, int s, int e) {
        String answer = "";

        distance[s] = cityProfit[s];

        for (int i = 0; i < node + 100; i++) {
            for (City city : cites) {
                int start = city.s;
                int end = city.e;
                int amount = city.fares;

                if(distance[start] == Long.MIN_VALUE) continue;
                else if(distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE;
                else if(distance[end] < distance[start] + cityProfit[end] - amount) {
                    distance[end] = distance[start] + cityProfit[end] - amount;
                    if(i >= node - 1) distance[end] = Long.MAX_VALUE;
                }
            }
        }

        if(distance[e] == Long.MIN_VALUE) answer = "gg";
        else if(distance[e] == Long.MAX_VALUE) answer = "Gee";
        else answer = String.valueOf(distance[e]);

        return answer;
    }

    static class City {
        int s, e;
        int fares;

        public City(int s, int e, int fares) {
            this.s = s;
            this.e = e;
            this.fares = fares;
        }
    }
}
