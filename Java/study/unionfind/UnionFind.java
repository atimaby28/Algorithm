package unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class UnionFind {
    public static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a + "과 " + b + "은 연결되어 있나요? " + isSameParent(a, b));

    }


    public static int find(int x) {
        if (x == unf[x])
            return x;
        else
            return unf[x] = find(unf[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 같은 부모를 가지고 있지 않을 때
        if (x != y) {
            // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
            unf[y] = x;
            // 더 작은 값으로 넣어 줄 때 다음과 같이도 표현 가능
            /*
             * if(x < y) parent[y] = x; else parent[x] = y;
             */
        }
    }

    // 같은 부모 노드를 가지는지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return true;
        else
            return false;
    }

}
