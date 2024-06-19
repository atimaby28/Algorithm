package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level2_가장큰수 {

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

        String result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] strNumber = new String[numbers.length];

        for (int i = 0; i < strNumber.length; i++) {
            strNumber[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumber, (o1, o2) -> (Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2))));

        for (String s : strNumber) {
            answer += s;
        }

        if(answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }

}
