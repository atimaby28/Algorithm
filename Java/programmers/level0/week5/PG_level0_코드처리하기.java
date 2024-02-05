package level0.week5;

import java.io.*;

public class PG_level0_코드처리하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = br.readLine();

        String result = solution(code);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String code) {
        String answer = "";

        int mod = 0;
        String ret = "";

        for (int i = 0; i < code.length(); i++) {
            if(mod == 0) {
                if(code.charAt(i) != '1' && i % 2 == 0) {
                    ret += code.charAt(i);
                } else if(code.charAt(i) == '1') {
                    mod = 1;
                }
            } else {
                if(code.charAt(i) != '1' && i % 2 != 0) {
                    ret += code.charAt(i);
                } else if(code.charAt(i) == '1') {
                    mod = 0;
                }
            }
        }

        if(ret.isEmpty()) {
            answer = "EMPTY";
        } else {
            answer = ret;
        }

        return answer;
    }

//    public String solution(String code) {
//        StringBuilder answer = new StringBuilder();
//        int mode = 0;
//        for (int i = 0; i < code.length(); i++) {
//            char current = code.charAt(i);
//            if (current == '1') {
//                mode = mode == 0 ? 1 : 0;
//                continue;
//            }
//
//            if (i % 2 == mode) {
//                answer.append(current);
//            }
//        }
//        return answer.length() == 0 ? "EMPTY" : answer.toString();
//    }

}
