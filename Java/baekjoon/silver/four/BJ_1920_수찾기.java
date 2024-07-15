package silver.four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] searchList = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < searchList.length; i++) {
            searchList[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] targetList = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetList.length; i++) {
            targetList[i] = Integer.parseInt(st.nextToken());
        }


        int[] result = solution(searchList, targetList);

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    private static int[] solution(int[] searchList, int[] targetList) {
        int[] answer = new int[searchList.length];

        Arrays.sort(searchList);

        for (int i = 0; i < targetList.length; i++) {
            answer[i] = binarySearch(searchList, targetList[i]);
        }

        return answer;
    }

    private static int binarySearch(int[] searchList, int target) {
        int answer = 0;

        int start = 0;
        int end = searchList.length - 1;

        while (start <= end) {
            int midIdx = (start + end) / 2;
            int midVal = searchList[midIdx];

            if(midVal < target) {
                start = midIdx + 1;
            } else if(midVal > target) {
                end = midIdx - 1;
            } else {
                answer = 1;
                break;
            }
        }

        return answer;
    }

}
