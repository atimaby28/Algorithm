package twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class 두배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[p];
        int[] arr2 = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr1, arr2);

        for (int i : result) {
            sb.append(i + " ");
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    private static int[] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];

        int pointer1 = 0;
        int pointer2 = 0;

        int idx = 0;
        while(pointer1 < arr1.length && pointer2 < arr2.length) {
            if(arr1[pointer1] <= arr2[pointer2]) {
                answer[idx] = arr1[pointer1++];
            } else if(arr1[pointer1] > arr2[pointer2]) {
                answer[idx] = arr2[pointer2++];
            }
            idx++;
        }

        while (pointer1 < arr1.length) {
            answer[idx] = arr1[pointer1++];
            idx++;
        }

        while (pointer2 < arr2.length) {
            answer[idx] = arr2[pointer2++];
            idx++;
        }

        return  answer;
    }

}

/*

input :
3 5
1 3 5
2 3 6 7 9

output :
1 2 3 3 5 6 7 9

 */


