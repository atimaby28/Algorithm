package level1.week4;

import java.io.*;

public class PG_level1_신규아이디추천 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String new_id = br.readLine();

        String result = solution(new_id);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String new_id) {
        String answer = "";

        new_id = new_id.toLowerCase().replaceAll("[^a-z0-9\\.\\-\\_]", "");

        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");


        if(new_id.isBlank()) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("\\.$", "");

        if(new_id.length() <= 2) {
            String temp = new_id.charAt(new_id.length() - 1) + "";
            new_id += temp.repeat(3 - new_id.length());
        }


        answer = new_id;

        return answer;
    }

}
