package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_접미사인지확인하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String is_suffix = st.nextToken();

        int result = solution(my_string, is_suffix);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String my_string, String is_suffix) {
        int answer = 0;

        answer = isSuffix(my_string, is_suffix, my_string.length() - 1, is_suffix.length() - 1);

        return answer;
    }

    private static int isSuffix(String myString, String isSuffix, int index1, int index2) {

        if(index2 < 0) {
            return 1;
        }

        if(myString.length() < isSuffix.length()
                || myString.charAt(index1) != isSuffix.charAt(index2)) {
            return 0;
        }

        return isSuffix(myString, isSuffix, index1 - 1, index2 - 1);
    }

}
