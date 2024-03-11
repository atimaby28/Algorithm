package level2.week1;

import java.io.*;
import java.util.*;

public class PG_level2_튜플 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String s) {
        int[] answer = {};

        HashMap<Integer, Integer> cntHsmap = new HashMap<>();

        s = s.substring(2, s.length() - 2);
        s = s.replaceAll("[{}]", "");

        String[] str = s.split(",");

        for (String splitNum : str) {
            int num = Integer.parseInt(splitNum);
            cntHsmap.put(num, cntHsmap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(cntHsmap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        answer = new int[cntHsmap.size()];

        int i = 0;
        for(Map.Entry<Integer, Integer> entry : entryList){
            answer[i++] = entry.getKey();
        }

        return answer;
    }

}
