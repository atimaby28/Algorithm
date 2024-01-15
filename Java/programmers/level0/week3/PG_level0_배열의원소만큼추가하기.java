package level0.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_배열의원소만큼추가하기 {

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

        int[] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(int[] arr) {
        int[] answer = {};

        answer = printSecondElement(arr, arr.length - 1);

        return answer;
    }

    public static int[] printSecondElement(int[] arr, int index) {
        if (index < 0) {
            return new int[0];
        }

        int[] temp = printSecondElement(arr, index - 1);
        int[] result = Arrays.copyOf(temp, temp.length + arr[index]);


        for (int i = 0; i < arr[index]; i++) {
            result[result.length - 1 - i] = arr[index];
        }

        return  result;
    }
}
