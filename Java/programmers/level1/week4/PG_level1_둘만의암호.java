package level1.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PG_level1_둘만의암호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String skip = st.nextToken();
        int index = Integer.parseInt(st.nextToken());

        String result = solution(s, skip, index);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static String solution(String s, String skip, int index) {
        String answer = "";

        char[] alphabet = new char[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        for (int i = 0; i < skip.length(); i++) {
            alphabet[skip.charAt(i) - 'a'] = '*';
        }

        for (int i = 0; i < s.length(); i++) {
            String temp = "";

            int j = 1;
            while(temp.length() != index) {
                char condition = alphabet[(s.charAt(i) - 'a' + j) % 26];
                if(condition != '*') {
                    temp += condition;
                }
                j++;
            }
            answer += temp.charAt(index - 1);
        }

        return answer;
    }
}
