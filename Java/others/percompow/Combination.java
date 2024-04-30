package percompow;

import java.io.*;
import java.util.StringTokenizer;

public class Combination {
    public static int N, R;
    public static int[] combi;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        combi = new int[R];
        sb = new StringBuilder();

        combination(1, 0);

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
    }

    private static void combination(int start, int depth) {
        if(depth == R) {
            for (int i = 0; i < combi.length; i++) {
                sb.append(combi[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            combi[depth] = i;
            combination(i + 1, depth + 1);
        }
    }
}
