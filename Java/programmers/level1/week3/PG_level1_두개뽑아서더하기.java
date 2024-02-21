package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PG_level1_두개뽑아서더하기 {

    public static HashSet<Integer> hset;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] numbers = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        check = new boolean[numbers.length];
        hset = new HashSet<>();

        combina(numbers, check, 0, 2);

        answer = new int[hset.size()];

        int i = 0;
        Iterator<Integer> iter = hset.iterator(); // set을 Iterator 안에 담기
        while(iter.hasNext()) { // iterator에 다음 값이 있다면
            answer[i++] = iter.next();
        }

        Arrays.sort(answer);

        return answer;
    }

    private static void combina(int[] numbers, boolean[] check, int s, int r) {
        if(r == 0) {
            int sum = 0;
            for (int j = 0; j < check.length; j++) {
                if(check[j]) {
                    sum += numbers[j];
                }
            }
            hset.add(sum);

            return;
        }

        for (int j = s; j < numbers.length; j++) {
            check[j] = true;
            combina(numbers, check, j + 1, r - 1);
            check[j] = false;
        }
    }

}
