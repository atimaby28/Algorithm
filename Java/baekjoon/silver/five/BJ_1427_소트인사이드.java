package silver.five;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(String s) {
        // 문자열을 정수형 배열로 변환
        int[] array = s.chars() // 문자열을 IntStream으로 변환
                .map(c -> c - '0') // 각 문자를 정수로 변환
                .toArray(); // IntStream을 배열로 변환
        
        selectionSort(array);

        // 정수 배열을 문자열로 반환
        return IntStream.of(array) // IntStream 생성
                .mapToObj(String::valueOf) // 각 정수를 문자열로 변환
                .collect(Collectors.joining());
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minIdx] < array[j])
                    minIdx = j;
            }
            swap(array, minIdx, i);
        }
    }

    private static void swap(int[] array, int minIdx, int i) {
        int temp = array[minIdx];
        array[minIdx] = array[i];
        array[i] = temp;
    }
}
