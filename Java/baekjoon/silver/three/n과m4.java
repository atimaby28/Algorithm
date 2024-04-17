package silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class n과m4 {

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

        combination(array, new int[n], 0, n, m);

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    public static void combination(int[] array, int[] output, int depth, int n, int m) {
        if(depth == m) {
            for (int i = 0; i < n; i++) {
                sb.append(output[i] + " ");
            }

            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = array[i];
            combination(array, output, depth + 1, n, m);
        }

    }
}
