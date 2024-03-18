package exhaust_recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Permutation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] output = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Permutation, For Loop; r : 3
        nestedFor(n);

        System.out.println();

        // Permutation, Lexical order
        permutation(arr, output, new boolean[n], 0, n, r);

        System.out.println();

        // permutation, Swap
        perm(arr, 0, n, 3);

        bw.flush();
        bw.close();
    }

    private static void nestedFor(int n) throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j != i) {
                    for (int k = 1; k <= n; k++) {
                        if (k != i && k != j) {
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
    }

    // 사전순으로 순열 구하기
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 순열 구하기
    static void perm(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            perm(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
