package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_n보다커질때까지더하기 {

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

        int n = Integer.parseInt(br.readLine());

        int result = solution(numbers, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] numbers, int n) {
        int answer = 0;

        answer = addNum(numbers, n, 0, 0);

        return answer;
    }

    private static int addNum(int[] numbers, int n, int i, int sum) {

        if(sum > n) {
            return sum;
        } else {
            sum += numbers[i];
        }

        return addNum(numbers, n, i + 1, sum);
    }
}
