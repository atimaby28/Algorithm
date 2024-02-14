package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_내적 {

    public  static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] a = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] b = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(a, b);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] a, int[] b) {
        int answer = 1234567890;

        answer = dotPro(a, b, a.length);

        return answer;
    }

    private static int dotPro(int[] a, int[] b, int length) {
        if(length == 0) {
            return sum;
        }

        return dotPro(a, b, length - 1) + (a[length] * b[length]);
    }

}
