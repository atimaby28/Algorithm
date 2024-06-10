package level2.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PG_level2_순위검색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int p = Integer.parseInt(br.readLine());

        String[] info = new String[p];
        for (int i = 0; i < info.length; i++) {
            info[i] = br.readLine();
        }

        int q = Integer.parseInt(br.readLine());

        String[] query = new String[q];
        for (int i = 0; i < query.length; i++) {
            query[i] = br.readLine();
        }

        int[] result = solution(info, query);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};

        LinkedList<ListNode> linkedList = new LinkedList<>();

        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
             
        }

        for (int i = 0; i < query.length; i++) {
            String[] s = query[i].split(" and ");



        }


        return answer;
    }

}

class ListNode {
    String data;
    ListNode prev;

    ListNode(ListNode prev, String data) {
        this.prev = prev;
        this.data = data;
    }

}
/*
6
java backend junior pizza 150
python frontend senior chicken 210
python frontend senior chicken 150
cpp backend senior pizza 260
java backend junior chicken 80
python backend senior chicken 50
6
java and backend and junior and pizza 100
python and frontend and senior and chicken 200
cpp and - and senior and pizza 250
- and backend and senior and - 150
- and - and - and chicken 100
- and - and - and - 150
 */