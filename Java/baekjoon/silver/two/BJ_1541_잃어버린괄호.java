package silver.two;

import java.io.*;
import java.util.Arrays;

public class BJ_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        
        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(String s) {
        int sum = 0;

        String[] expression = s.split("-");

        sum = Arrays.stream(expression[0].split("\\+"))
                .mapToInt(Integer::parseInt) // Convert each string to an integer
                .sum();

        for (int i = 1; i < expression.length; i++) {
            String[] minusExp = expression[i].split("\\+");

            for (int j = 0; j < minusExp.length; j++) {
                sum -= Integer.parseInt(minusExp[j]);
            }
        }

        return sum;
    }
}
