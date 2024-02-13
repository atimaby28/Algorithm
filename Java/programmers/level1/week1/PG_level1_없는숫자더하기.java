package level1.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_없는숫자더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] numbers = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int solution(int[] numbers) {
        int answer = -1;

        boolean[] check = new boolean[10];

        for (int n : numbers) {
            check[n] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if(!check[i]) {
                answer += i;
            }
        }

        return answer;
    }

//    public int solution(int[] numbers) {
//        int sum = 45;
//        for (int i : numbers) {
//            sum -= i;
//        }
//        return sum;
//    }
}
