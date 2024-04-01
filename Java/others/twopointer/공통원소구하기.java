package twopointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공통원소구하기 {

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
        int[] answer = {};

        ArrayList<Integer> arrlist = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int pointer1 = 0, pointer2 = 0;
//&& pointer2 != arr2.length
        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            if(arr1[pointer1] > arr2[pointer2]) {
                pointer2++;
            } else if(arr1[pointer1] < arr2[pointer2]) {
                pointer1++;
            } else {
                arrlist.add(arr1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }

        answer = new int[arrlist.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrlist.get(i);
        }

        return answer;
    }

}


/*

input :
5 5
1 3 9 5 2
3 2 5 7 9

output :
2 3 5

 */
