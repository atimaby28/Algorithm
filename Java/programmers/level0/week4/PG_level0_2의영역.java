package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_2의영역 {

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

        int firstIdx = -1;
        int lastIdx =  -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                firstIdx = i;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                lastIdx = i;
            }
        }

        if(firstIdx == -1 || lastIdx == -1) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = -1;
        } else {
            for (int i = firstIdx; i <= lastIdx; i++) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = arr[i];
            }
        }

        return answer;
    }
    
}
