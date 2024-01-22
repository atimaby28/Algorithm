package level0.week4;

import java.io.*;

public class PG_level0_9로나눈나머지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String my_string = br.readLine();

        int result = solution(my_string);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String number) {
        int answer = 0;

        int digitSum = 0;

        for (int i = 0; i < number.length(); i++) {
            digitSum += number.charAt(i) - '0';
        }

        answer = digitSum % 9;

        return answer;
    }

}
