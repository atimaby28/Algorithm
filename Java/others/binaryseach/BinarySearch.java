package binaryseach;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] array = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(array, target);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] array, int target) {
        int answer = -1;

        Arrays.sort(array);

        int lt = 0, rt = array.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if(array[mid] == target) {
                answer = mid + 1;
                break;
            }

            if(array[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}

/*

input :
8 32
23 87 65 12 57 32 99 81

output :
3

 */
