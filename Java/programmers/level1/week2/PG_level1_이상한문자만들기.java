package level1.week2;

import java.io.*;

public class PG_level1_이상한문자만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");

        for (int i = 0; i < strArr.length; i++) {

            char[] charArr = strArr[i].toCharArray();
            for (int j = 0; j < strArr[i].length(); j++) {
                if(j % 2 == 0) {
                    charArr[j] = (charArr[j] + "").toUpperCase().charAt(0);
                } else {
                    charArr[j] = (charArr[j] + "").toLowerCase().charAt(0);
                }
            }

            String temp = "";
            for (char c : charArr) {
                temp += c;
            }

            strArr[i] = temp;

        }

        for (String str : strArr) {
            answer += str;
            answer += " ";
        }

        answer = answer.substring(0, answer.length() - 1);

        return answer;
    }

}
