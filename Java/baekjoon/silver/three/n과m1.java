package silver.three;

import java.io.*;
import java.util.StringTokenizer;

// 순열
public class n과m1 {

    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        permutation(array, new boolean[n], new int[n], 0, n, m);

    }

    private static void permutation(int[] array, boolean[] visited, int[] output, int depth, int n, int m) {
        if(m == 0) {
            for (int i = 0; i < depth; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                permutation(array, visited, output, depth + 1, n, m - 1);
                visited[i] = false;
            }
        }
    }
}
