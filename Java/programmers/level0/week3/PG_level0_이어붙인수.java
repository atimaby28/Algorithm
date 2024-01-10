package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_이어붙인수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] num_list = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] num_list) {
        int answer = 0;

        String evenSum = sumEven(num_list, num_list.length - 1);

        String oddSum = sumOdd(num_list, num_list.length - 1);

        System.out.println(evenSum + " " + oddSum);

        return answer;
    }

    private static String sumEven(int[] num_list, int i) {
        if(i == 0) {
            return "";
        }

        String sum = sumEven(num_list, i - 1);

        if(num_list[i] % 2 == 0) {
            sum += num_list[i];
        }

        return  sum;
    }

    private static String sumOdd(int[] numList, int i) {
        if(i == -1) {
            return "";
        }

        String sum = sumOdd(numList, i - 1);

        if(numList[i] % 2 != 0) {
            sum += numList[i];
        }

        return  sum;

    }

}
