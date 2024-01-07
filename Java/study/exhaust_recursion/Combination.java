package exhaust_recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] input;
    private static int[] numbers;

    public static void main(String[] args) throws NumberFormatException, IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        input = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        numbers = new int[n];

        // for
        nestedFor(n);

        bw.write("\n");

        // Combination
        combination(0, 0, n, r);

        bw.flush();
        bw.close();
    }

    private static void nestedFor(int n) throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    bw.write(i + " " + j + " " + k + " " + "\n");
                }
            }
        }
    }

    private static void combination(int cnt, int start, int n, int r) throws IOException {
        if (cnt == r) {
			System.out.println(Arrays.toString(numbers));
            return;
        }
        // start 위치의 수부터 가능한 수 모두 고려
        for (int i = start; i < n; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1, n, r);
        }
    }

}
