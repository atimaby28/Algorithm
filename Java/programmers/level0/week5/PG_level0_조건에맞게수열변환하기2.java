package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_조건에맞게수열변환하기2 {

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

        int result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {

            int temp = 0;
            int count = 0;
            while (arr[i] != temp) {
                temp = arr[i];
                if(arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] = arr[i] / 2;
                } else if(arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1;
                }

                count++;

            }

            answer = Math.max(answer, count);

        }

        return answer - 1;
    }

}
