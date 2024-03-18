package level2.week2;

import java.io.*;
import java.util.*;

public class PG_level2_뒤에있는큰수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] numbers = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(int[] numbers) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        int creteria = -1;

        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] < creteria) {
                queue.add(creteria);
                continue;
            }
            boolean flag = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] < numbers[j]) {
                    creteria = numbers[j];
                    queue.add(creteria);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                queue.add(-1);
            }
        }

        answer = new int[queue.size()];

        int i = 0;
        while (!queue.isEmpty()) {
            answer[i] = queue.poll();
        }

        return answer;
    }

}
