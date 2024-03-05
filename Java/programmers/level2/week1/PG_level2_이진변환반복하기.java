package level2.week1;

import java.io.*;

public class PG_level2_이진변환반복하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int remove = 0;
        while (!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0+", "");

            remove += (len - s.length());
            System.out.println(remove);
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = remove;

        return answer;
    }

}
