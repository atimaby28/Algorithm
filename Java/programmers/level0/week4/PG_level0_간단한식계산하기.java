package level0.week4;

import java.io.*;

public class PG_level0_간단한식계산하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        int result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String binomial) {
        int answer = 0;

        String[] str = binomial.split(" ");

        if(str[1].equals("+")) {
            answer = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
        } else if(str[1].equals("-")) {
            answer = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
        } else if (str[1].equals("*")) {
            answer = Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
        }

        return answer;
    }

}
