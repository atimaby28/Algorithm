package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_2개이하로다른비트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        long[] numbers = new long[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        long[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long[] solution(long[] numbers) {
        long[] answer = {};

        answer = new long[numbers.length];

        for (int i = 0; i < numbers.length ; i++) {
            int j = 1;
            for (; j < 1000000; j++) {
                String str = Long.toBinaryString(numbers[i] ^ numbers[i] + j).;

                System.out.println(str);

                int count = 0;
                for (int k = 0; k < str.length(); k++) {
                    if(str.charAt(k) == '1') {
                        count++;
                    }
                }
                if(count <= 2) {
                    break;
                }
            }
            System.out.println();
            answer[i] = numbers[i] + j;
        }

        return answer;
    }

}
