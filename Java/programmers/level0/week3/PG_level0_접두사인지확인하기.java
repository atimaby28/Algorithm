package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_접두사인지확인하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String my_string = st.nextToken();
        String is_prefix = st.nextToken();

        int result = solution(my_string, is_prefix);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String my_string, String is_prefix) {
        int answer = 1;

        if(is_prefix.length() > my_string.length()) {
            answer = 0;
            return answer;
        }

        for (int i = 0; i < is_prefix.length(); i++) {
            if(is_prefix.charAt(i) != my_string.charAt(i)) {
                answer = 0;
                break;
            }
        }

        return answer;
    }

    // startWith
//    public int solution(String my_string, String is_prefix) {
//        if (my_string.startsWith(is_prefix)) return 1;
//        return 0;
//    }

    // indexOf
//    public int solution(String my_string, String is_prefix) {
//        int answer = 0;
//        int a = my_string.indexOf(is_prefix);
//        System.out.print(a);
//
//        return a==0? 1 : 0;
//    }

}
