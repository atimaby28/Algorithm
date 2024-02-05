package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_배열조각하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] arr = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] query = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < query.length; i++) {
            query[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr, query);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int[] query) {
        int[] answer = {};

        for (int i = 0; i < query.length; i++) {

            if(i % 2 == 0) {
                arr = Arrays.copyOf(arr, query[i] + 1);
            } else {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }

        answer = arr;

        return answer;
    }

//    public int[] solution(int[] arr, int[] query) {
//        int start = 0;
//        int end = arr.length - 1;
//        for (int i = 0; i < query.length; i++) {
//            if (i % 2 == 0) {
//                end = start + query[i] - 1;
//            } else {
//                start += query[i];
//            }
//        }
//
//        return Arrays.copyOfRange(arr, start, end + 2);
//    }

}
