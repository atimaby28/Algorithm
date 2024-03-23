package level2.week2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level2_롤케이크자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] topping = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < topping.length; i++) {
            topping[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(topping);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] topping) {
        int answer = -1;

        HashMap<Integer, Integer> chulSu = new HashMap<>();
        HashMap<Integer, Integer> dongSaeng = new HashMap<>();

        int mid = topping.length / 2;

        int count = 0;
        for (int i = 0; i < mid; i++) {
            chulSu.put(topping[i], chulSu.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = mid; i < topping.length; i++) {
            dongSaeng.put(topping[i], dongSaeng.getOrDefault(topping[i], 0) + 1);
        }

        if(chulSu.size() == dongSaeng.size()) {
            count++;
        }

        HashMap<Integer, Integer> chulSuCopy1 = new HashMap<>(chulSu);
        HashMap<Integer, Integer> dongSaengCopy1 = new HashMap<>(dongSaeng);

        for (int i = 0; i < mid; i++) {
            chulSuCopy1.put(topping[mid - i], chulSuCopy1.getOrDefault(topping[mid - i], 0) - 1);
            dongSaengCopy1.put(topping[mid - i], dongSaengCopy1.getOrDefault(topping[mid - i], 0) + 1);

            if(chulSuCopy1.get(topping[mid - i]) == 0 ) {
                chulSuCopy1.remove(topping[mid - i]);
            }

            if(dongSaengCopy1.get(topping[mid - i]) == 0 ) {
                dongSaengCopy1.remove(topping[mid - i]);
            }

            if(chulSuCopy1.size() == dongSaengCopy1.size()) {
                count++;
            }

        }

        HashMap<Integer, Integer> chulSuCopy2 = new HashMap<>(chulSu);
        HashMap<Integer, Integer> dongSaengCopy2 = new HashMap<>(dongSaeng);

        for (int i = mid; i < topping.length - 1; i++) {
            chulSuCopy2.put(topping[i], chulSuCopy2.getOrDefault(topping[i], 0) + 1);
            dongSaengCopy2.put(topping[i], dongSaengCopy2.getOrDefault(topping[i], 0) - 1);

            if(chulSuCopy2.get(topping[i]) == 0 ) {
                chulSuCopy2.remove(topping[i]);
            }

            if(dongSaengCopy2.get(topping[i]) == 0 ) {
                dongSaengCopy2.remove(topping[i]);
            }

            if(chulSuCopy2.size() == dongSaengCopy2.size()) {
                count++;
            }
        }

        answer = count;

        return answer;
    }

}
