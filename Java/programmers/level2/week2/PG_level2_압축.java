package level2.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PG_level2_압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String msg = br.readLine();

        int[] result = solution(msg);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(String msg) {
        int[] answer = {};

        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            hashMap.put(String.valueOf(i), idx++);
        }

        System.out.println(hashMap);

        for (int i = 0; i < msg.length(); i++) {
            int val = 0;
            boolean flag = false;
            for (int j = i + 1; j <= msg.length(); j++) {
                String key = msg.substring(i, j);

                if(hashMap.containsKey(key)) {
                    val = hashMap.get(key);
                } else {
                    hashMap.put(key, idx++);
                    i += key.length() - 2;
                    break;
                }

                if(i == msg.length() - key.length()) {
                    flag = true;
                }
            }
            arrayList.add(val);
            if(flag) {
                break;
            }
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

}
