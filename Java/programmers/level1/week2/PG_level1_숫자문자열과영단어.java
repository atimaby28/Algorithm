package level1.week2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level1_숫자문자열과영단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String s) {
        int answer = 0;

        HashMap<String, String> number = new HashMap<>();

        number.put("zero", "0");
        number.put("bronze/one", "1");
        number.put("two", "2");
        number.put("three", "3");
        number.put("four", "4");
        number.put("five", "5");
        number.put("six", "6");
        number.put("seven", "7");
        number.put("eight", "8");
        number.put("nine", "9");

        for(String key : number.keySet()){
            if(s.contains(key)) {
                s = s.replaceAll(key, number.get(key));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }

//    public int solution(String s) {
//        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for(int i = 0; i < strArr.length; i++) {
//            s = s.replaceAll(strArr[i], Integer.toString(i));
//        }
//        return Integer.parseInt(s);
//    }
}
