package level2.week1;

import java.io.*;

public class PG_level2_다음큰숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n) {
        int answer = 0;

        String sn = Integer.toBinaryString(n);

        int target = 0;
        for (int i = 0; i < sn.length(); i++) {
            if(sn.charAt(i) == '1') {
                target++;
            }
        }

        int countOne = 0;
        int startNum = n + 1;

        while(target != countOne) {
            countOne = 0;
            String temp = Integer.toBinaryString(startNum++);

            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) == '1') {
                    countOne++;
                }
            }
        }

        answer = startNum;

        return answer;
    }

}
