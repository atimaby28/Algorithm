package level2.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_타겟넘버 {

    public static int count = 0;

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

        int target = Integer.parseInt(br.readLine());

        int  result = solution(numbers, target);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, 0, target, 0);

        answer = count;

        return answer;
    }

    private static void dfs(int[] numbers, int depth, int target, int result) {
        if(depth == numbers.length) {
            if(target == result) {
                count++;
            }
            return;
        }

        int plus = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers, depth + 1, target, plus);
        dfs(numbers, depth + 1, target, minus);

    }


}
