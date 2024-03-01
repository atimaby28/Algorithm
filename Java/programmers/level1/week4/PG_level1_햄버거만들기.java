package level1.week4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level1_햄버거만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] ingredient = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ingredient.length; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(ingredient);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {

        }

        return answer;
    }

}
