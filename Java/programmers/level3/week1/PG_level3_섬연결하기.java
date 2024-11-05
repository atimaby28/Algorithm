package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_섬연결하기 {

    static int ans;
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n + 1][3];

        for (int i = 0; i < cost.length; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, cost);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        ArrayList<Island> arrayList = new ArrayList<>();

        unf = new int[n + 1];

        // 유니온 파인드 초기화
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            arrayList.add(new Island(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(arrayList);

        kruskal(arrayList, n - 1);

        answer = ans;

        return answer;
    }

    private static void kruskal(ArrayList<Island> arrayList, int cnt) {
        for (Island e : arrayList) {
            int fromEdge = find(e.from);
            int toEdge = find(e.to);

            if(fromEdge != toEdge) {
                ans += e.weight;
                cnt--;
                union(e.from, e.to);
            }

            if(cnt == 0) {
                return;
            }
        }
    }

    public static int find(int v) {
        if(v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int from, int to) {
        int fromEdge = find(from);
        int toEdge = find(to);

        if (fromEdge != toEdge) {
            unf[toEdge] = fromEdge;
        }
    }
}

class Island implements Comparable<Island> {

    int from, to, weight;

    Island(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Island o) {
        return Integer.compare(this.weight, o.weight);
    }
}