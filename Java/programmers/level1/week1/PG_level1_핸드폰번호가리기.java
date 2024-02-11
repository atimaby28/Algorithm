package level1.week1;

import java.io.*;

public class PG_level1_핸드폰번호가리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String phone_number = br.readLine();

        String result = solution(phone_number);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String phone_number) {
        String answer = "";

        String num = phone_number.substring(phone_number.length() - 4);

        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }

        answer += num;

        return answer;
    }

//    public String solution(String phone_number) {
//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
//    }

}
