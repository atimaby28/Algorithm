package silver.one;

import java.io.*;
import java.util.*;

public class BJ_1446_지름길 {

    public static int N;
    public static int D;

    public static List<ShortPath> paths;
    public static Pair[] pairs;

    public static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        paths = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(to > D) {
                continue;
            }

            if(dist >= (to - from)) {
                continue;
            }

            paths.add(new ShortPath(from, to, dist));
        }

        pairs = new Pair[D + 1];

        for (int i = 0; i < pairs.length; i++) {
            Pair p = new Pair(i, Integer.MAX_VALUE);
            pairs[i] = p;
        }

        dijkstra(pairs[0]);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

    private static void dijkstra(Pair p) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(p);

        p.dist = 0;

        while (!priorityQueue.isEmpty()) {
            Pair front = priorityQueue.poll();
            if(front.no == D) {
                break;
            }

            Pair next = pairs[front.no + 1];
            if(next.dist > front.dist + 1) {
                next.dist = front.dist + 1;
                priorityQueue.offer(next);
            }

            for (ShortPath path : paths) {
                if(path.from == front.no) {
                    Pair spNext = pairs[path.to];
                    if(spNext.dist > front.dist + path.dist) {
                        spNext.dist = front.dist + path.dist;
                        priorityQueue.offer(spNext);
                    }
                }
            }
        }

        ans = pairs[D].dist;

    }
}

class Pair implements Comparable<Pair> {
    int no, dist;

    public Pair(int no, int dist) {
        this.no = no;
        this.dist = dist;
    }


    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.dist, o.dist);
    }
}

class  ShortPath {
    int from;
    int to;
    int dist;

    public ShortPath(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}