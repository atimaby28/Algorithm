package level2.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_N개의최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] arr) {
        int answer = 0;

        answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b,a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
