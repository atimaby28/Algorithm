package percompow;

import java.io.*;
import java.util.StringTokenizer;

public class Permutation {
    public static int N, R;
    public static int[] output;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        output = new int[R];
        visited = new boolean[N];
        sb = new StringBuilder();

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        permutation(array, 0);

        bw.write(sb.toString() + " ");

        bw.flush();
        bw.close();
    }

    private static void permutation(int[] array, int depth) {
        if(depth == R) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                permutation(array, depth + 1);
                visited[i] = false;
            }
        }

    }
}
