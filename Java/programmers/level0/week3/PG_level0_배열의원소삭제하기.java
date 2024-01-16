package level0.week3;

import java.io.*;
import java.util.*;

public class PG_level0_배열의원소삭제하기 {

    public static LinkedHashSet<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[p];
        int[] delete_list = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < delete_list.length; i++) {
            delete_list[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr, delete_list);

        for (int i : result) {
            System.out.print(i);
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i : delete_list) {
            if(set.contains(i)) {
                set.remove(i);
            }
        }

        answer = new int[set.size()];

        Iterator iter = set.iterator();

        int i = 0;
        while (iter.hasNext()) {
            answer[i++] =  Integer.parseInt(iter.next().toString());
        }

        return answer;
    }

//    public int[] solution(int[] arr, int[] delete_list) {
//        List<Integer> list = new ArrayList<>();
//        for(int n : arr) {
//            list.add(n);
//        }
//        for(int n: delete_list) {
//            list.remove((Integer)n);
//        }
//        int[] answer = new int[list.size()];
//        for(int i=0; i<list.size(); i++){
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }

}
