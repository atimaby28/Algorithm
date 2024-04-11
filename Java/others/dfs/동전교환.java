package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 동전교환 {

    public static int[] coin;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        coin = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n];

        int result = solution(n, coin, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int n, int[] coin, int m) {
        int answer = 0;

        dfs(coin, 0, 0, m);

        return answer;
    }

    private static void dfs(int[] coin, int sum, int depth, int limit) {

        if(sum > limit) {
            return;
        }

        if(sum == limit) {
            System.out.println(sum + " " + depth);
        }

        for (int i = 0; i < coin.length; i++) {
            dfs(coin, sum + coin[i], depth + 1, limit);
        }

//        dfs(coin, sum + coin[depth], depth + 1, limit);

    }


}

/*

input :
3
1 2 5
15

output :
3

 */