package level2.week2;

import java.io.*;
import java.util.HashMap;

public class PG_level2_오픈채팅방 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] record = new String[k];

        for (int i = 0; i < record.length; i++) {
            record[i] = br.readLine();
        }

        String[] result = solution(record);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> hashMap = new HashMap<>();

        String[][] log = new String[record.length][3];

        String enter = "님이 들어왔습니다.";
        String exit = "님이 나갔습니다.";

        int changeCnt = 0;
        for (int i = 0; i < record.length; i++) {
            log[i] = record[i].split(" ");

            if(!log[i][0].equals("Leave")) {
                hashMap.put(log[i][1], log[i][2]);
            }
            if(log[i][0].equals("Change")) {
                changeCnt++;
            }
        }

        answer = new String[record.length - changeCnt];

        int k = 0;
        for (int i = 0; i < record.length; i++) {
            if(log[i][0].equals("Enter")) {
                answer[k++] = hashMap.get(log[i][1]) + enter;
            } else if (log[i][0].equals("Leave")) {
                answer[k++] = hashMap.get(log[i][1]) + exit;
            }
        }
        return answer;
    }

}