package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_키패드누르기 {

    public static int[] dir = {-3, 3, -1, 1, -4, 4, -2, 2, -7, 7, -5, 5, -6, 6};

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

        int leftPos = -1;
        int rightPos = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += 'L';
                leftPos = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += 'R';
                rightPos = numbers[i];
            } else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {

            }
        }

        return answer;
    }

}
