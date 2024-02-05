package level0.week5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_level0_배열만들기2 {

    private static boolean[] isSelected;
    public static ArrayList<Integer> arrlist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] result = solution(l, r);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(int l, int r) throws IOException {
        int[] answer = {};

        isSelected = new boolean[Integer.toString(r).length()];


        powerset(0, Integer.toString(r).length());

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < arrlist.size(); i++) {
            if(l <= arrlist.get(i) && r >= arrlist.get(i)) {
                temp.add(arrlist.get(i));
            }
        }

        answer = new int[temp.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        if(answer.length == 0) {
            answer = new int[]{-1};
        }

        return answer;
    }

    private static void powerset(int cnt, int n) throws IOException {
        if(cnt == n) {
            String temp = "";
            for (int i = 0; i < n; i++) {

                temp += (isSelected[i] ? "5" : "0");
            }
            arrlist.add(Integer.parseInt(temp));
            return;
        }

        isSelected[cnt] = false;
        powerset(cnt+1, n);
        isSelected[cnt] = true;
        powerset(cnt+1, n);
    }


}
