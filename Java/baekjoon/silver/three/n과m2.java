package silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합
public class n과m2 {

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

        combination(array, new boolean[n], 0, n, m);

    }

    public static void combination(int[] array, boolean[] visited, int depth, int n, int m) {
        if(m == 0) {
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();

            return;
        }

        for (int i = depth; i < n; i++) {
            visited[i] = true;
            combination(array, visited, i + 1, n, m - 1);
            visited[i] = false;
        }

    }
}
