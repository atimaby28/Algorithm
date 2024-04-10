package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 바둑이승차 {

    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] w = new int[n];

        for (int i = 0; i < w.length; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        int result = solution(c, n, w);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int c, int n, int[] w) {
        int answer = 0;


        dfs(w, 0, c, n - 1);

        answer = ans;

        return answer;
    }

    private static void dfs(int[] w, int sum, int c, int depth) {
        if(depth < 0) {
            System.out.println(sum);
            if(sum <= c) {
                ans = Math.max(ans, sum);
            }
            return;
        }

        dfs(w, sum + w[depth], c, depth - 1);
        dfs(w, sum, c, depth - 1);

    }

}

/*

input :
259 5
81
58
42
33
61

output :
242

 */