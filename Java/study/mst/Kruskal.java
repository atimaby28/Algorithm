package mst;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Kruskal {

    public static int ans;
    public static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];

        ArrayList<KruskalEdge> arrayList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrayList.add(new KruskalEdge(from, to , weight));
        }

        Collections.sort(arrayList);

        kruskal(arrayList, n - 1);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

    private static void kruskal(ArrayList<KruskalEdge> arrayList, int cnt) {
        for (KruskalEdge e : arrayList) {
            int fromEdge = find(e.from);
            int toEdge = find(e.to);

            if(fromEdge != toEdge) {
                ans += e.weight;
                cnt--;
                union(e.from, e.to);
            }

            // 간선의 갯수 - 1 = 트리의 완성, 더 이상 탐색은 무의미 하므로 종료
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

class KruskalEdge implements Comparable<KruskalEdge> {

    int from, to, weight;

    KruskalEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(KruskalEdge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

