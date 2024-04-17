package silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class n과m3 {

    public static int[] array;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        permutation(array, new int[n], 0, n, m);

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    private static void permutation(int[] array, int[] output, int depth, int n, int m) {
        if(m == 0) {
            for (int i = 0; i < depth; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = array[i];
            permutation(array, output, depth + 1, n, m - 1);
        }
    }
}
