package gold.four;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리_Kruskal {

    public static int V, E;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayList<KruskalEdge> arrayList = new ArrayList<>();

        parents = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList.add(new KruskalEdge(a, b, c));
        }

        Collections.sort(arrayList);

        int mst = kruskal(arrayList);

        bw.write(mst + "\n");

        bw.flush();
        bw.close();
    }

    private static int kruskal(ArrayList<KruskalEdge> arrayList) {
        int weight = 0;
        int edgeCount = 0;
        for (KruskalEdge e : arrayList) {
            int from = find(e.from);
            int to = find(e.to);

            if (from != to) {
                union(from, to);
                weight += e.weight;
                edgeCount++;
            }

            if (edgeCount == E - 1) {
                return weight;
            }
        }
        return 0;
    }

    private static void union(int from, int to) {
        int nFrom = find(from);
        int nTo = find(to);

        if(nFrom != nTo) {
            parents[nTo] = nFrom;
        }

    }

    private static int find(int v) {
        if (v == parents[v]) {
            return v;
        } else {
            return parents[v] = find(parents[v]);
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