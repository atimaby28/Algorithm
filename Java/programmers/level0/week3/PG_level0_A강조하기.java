package level0.week3;

import java.io.*;

public class PG_level0_A강조하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        String result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String myString) {
        String answer = "";

        char[] charStr = myString.toLowerCase().toCharArray();

        for (int i = 0; i < charStr.length; i++) {
            if(charStr[i] == 'a') {
                charStr[i] = (char) (charStr[i] - ' ');
            }
        }

        for (char c : charStr) {
            answer += c;
        }

        return answer;
    }

//    public String solution(String myString) {
//        myString = myString.toLowerCase();
//        myString = myString.replace('a', 'A');
//
//        return myString;
//    }

}
