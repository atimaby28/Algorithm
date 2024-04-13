package exhaust_recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Powerset {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // PowerSet, For Loop; r : 3
        nestedFor(arr, visited, n);

        System.out.println();

        // PowerSet, Backtracking
        powerSet(arr, visited, n);

        System.out.println();

        // PowerSet, Bit
        powerSetBit(arr, n);

        bw.flush();
        bw.close();
    }

    private static void nestedFor(int[] arr, boolean[] visited, int n) throws IOException {
        for (int i = 1; i <= 2; i++) {
            visited[0] = i % 2 != 0 ? true : false;
            for (int j = 1; j <= 2; j++) {
                visited[1] = j % 2 != 0 ? true : false;
                for (int k = 1; k <= 2; k++) {
                    visited[2] = k % 2 != 0 ? true : false;
                    for (int m = 0; m < n; m++) {
                        System.out.print(visited[m] ? arr[m]: "X");
                    }
                    System.out.println();
                }
            }
        }
    }

    static void powerSet(int[] arr, boolean[] visited, int depth) {
        if (depth == 0) {

            for (int i = 0; i < arr.length; i++) {
                if (visited[i] == true)
                    System.out.print(arr[i] + " ");
            }

            System.out.println();

            return;
        }

        visited[depth - 1] = false;
        powerSet(arr, visited, depth - 1);

        visited[depth - 1] = true;
        powerSet(arr, visited, depth - 1);
    }

    static void powerSetBit(int[] arr, int n) {
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

}
