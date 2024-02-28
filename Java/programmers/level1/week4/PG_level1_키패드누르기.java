package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_키패드누르기 {

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

        String hand = br.readLine();

        String result = solution(numbers, hand);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        


        return answer;
    }

}
