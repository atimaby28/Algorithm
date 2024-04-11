package exhaust_recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Permutation_Rep {
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

        // Permutation with repetition, Lexical order
        permutation(arr, output, 0, n, r);

        bw.flush();
        bw.close();
    }

    private static void permutation(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }

            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            permutation(arr, output, depth + 1, n, r);
        }

    }


}
