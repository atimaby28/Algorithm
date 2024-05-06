package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_숫자카드나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arrayA = new int[k];
        int[] arrayB = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(arrayA, arrayB);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = arrayA[0];
        for (int i = 0; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];
        for (int i = 0; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int divider = Math.max(gcdA, gcdB);
        boolean flagA = true;
        boolean flagB = true;
        boolean zeroFlagA = false;
        boolean zeroFlagB = false;

        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % divider == 0) {
                zeroFlagA = true;
            }

            if(arrayA[i] % divider != 0) {
                flagA = false;
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % divider == 0) {
                zeroFlagB = true;
            }

            if(arrayB[i] % divider != 0) {
                flagB = false;
            }
        }

        if(flagA ^ flagB) {
            answer = divider;
            if(zeroFlagA && flagB) {
                answer = 0;
            }
            if(zeroFlagB && flagA) {
                answer = 0;
            }
        }

        return answer;
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b,a % b);
    }


}
