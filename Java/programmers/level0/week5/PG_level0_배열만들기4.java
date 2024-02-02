package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_배열만들기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr) {
        int[] stk = {};

        int i = 0;

        while(i < arr.length) {
            if(stk.length == 0) {
                stk = Arrays.copyOf(stk, stk.length + 1);
                stk[stk.length - 1] = arr[i];
                i++;
            } else if(stk[stk.length - 1] < arr[i]) {
                stk = Arrays.copyOf(stk, stk.length + 1);
                stk[stk.length - 1] = arr[i];
                i++;
            } else if(stk[stk.length - 1] >= arr[i]) {
                stk = Arrays.copyOf(stk, stk.length - 1);
            }
        }

        return stk;
    }

}
