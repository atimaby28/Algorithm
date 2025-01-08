package gold.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1717_집합의표현 {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] unionArray = new int[m][3];

        for (int i = 0; i < unionArray.length; i++) {
            st = new StringTokenizer(br.readLine());
            unionArray[i][0] = Integer.parseInt(st.nextToken());
            unionArray[i][1] = Integer.parseInt(st.nextToken());
            unionArray[i][2] = Integer.parseInt(st.nextToken());
        }

        String result = solution(unionArray, n);

        bw.write(result);

        bw.flush();
        br.close();
        bw.close();
    }

    private static String solution(int[][] unionArray, int n) {
        StringBuilder sb = new StringBuilder();

        unf = new int[n + 1];

        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < unionArray.length; i++) {
            int x = unionArray[i][1];
            int y = unionArray[i][2];
            if(unionArray[i][0] == 0) {
                union(x, y);
            } else {
                x = find(x);
                y = find(y);

                if(x == y) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        return sb.toString();
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            unf[y] = x;
        }
    }

    private static int find(int x) {
        if(x == unf[x]) {
            return x;
        } else {
            return unf[x] = find(unf[x]);
        }
    }
}
