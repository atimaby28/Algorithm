package level2.week3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PG_level2_문자열압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            int count = 1;
            String last = "";
            String compressed = "";
            String beforeKey = s.substring(0, i);

            for (int j = i; j < s.length(); j += i) {
                if(j + i <= s.length()) {
                    String key = s.substring(j, j + i);

                    if(key.equals(beforeKey)) {
                        count++;

                    } else {
                        if(count == 1) {
                            compressed += beforeKey;
                        } else {
                            compressed += (count + beforeKey);
                        }
                        count = 1;
                        beforeKey = key;
                    }

                } else {
                    last = s.substring(j);
                    break;
                }
            }

            if(count == 1) {
                compressed += beforeKey;
            } else {
                compressed += (count + beforeKey);
            }

            if(s.length() % i != 0) {
                compressed += last;
            }

            answer = Math.min(answer, compressed.length());

        }

        return answer;
    }

}
