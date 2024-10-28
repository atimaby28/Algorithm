package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_햄버거만들기 {

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] ingredients = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(ingredients);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] ingredients) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int ingredient : ingredients) {
            stack.push(ingredient);

            if (stack.size() >= 4 && stack.get(stack.size() - 1) == 1 && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 4) == 1) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();

                answer++;
            }
        }

        return answer;
    }


}

//[2, 1, 1, 2, 3, 1, 2, 3, 1]