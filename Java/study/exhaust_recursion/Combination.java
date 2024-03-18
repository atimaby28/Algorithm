package exhaust_recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Combination, For Loop; r : 3
        nestedFor(n);

        System.out.println();

        // Combination, Backtracking
        combination(arr, visited, 0, n, r);

        System.out.println();

        // Combination, Recursive
        comb(arr, visited, 0, n, r);

        bw.flush();
        bw.close();
    }

    private static void nestedFor(int n) throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }


    // 백트래킹 사용
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println();

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 재귀 사용
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println();

            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

}
