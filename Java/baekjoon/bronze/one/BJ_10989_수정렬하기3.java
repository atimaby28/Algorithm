package bronze.one;

import java.io.*;

public class BJ_10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        int max = 0; // 입력값 중 최대값을 저장할 변수

        // 입력값 처리 및 최대값 찾기
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (array[i] > max) {
                max = array[i];
            }
        }

        String result = solution(array, max);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int[] array, int max) {
        StringBuilder sb = new StringBuilder();

        // Radix Sort 실행
        radixSort(array, max);

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append("\n");
        }

        return sb.toString();
    }

    // Radix Sort 구현
    public static void radixSort(int[] array, int max) {
        int n = array.length;

        int exp = 1; // 현재 자리수 (1의 자리, 10의 자리, 100의 자리 등)
        int[] output = new int[n];

        while (max / exp > 0) {
            int[] count = new int[10]; // 현재 자리수에서 0~9의 개수를 저장할 배열

            // 현재 자리수의 숫자를 기준으로 개수를 셈
            for (int num : array) {
                count[(num / exp) % 10]++;
            }

            // 누적 합을 계산하여 각 숫자가 정렬될 위치를 결정
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // output 배열에 정렬된 값을 저장 (뒤에서부터 처리하여 안정성 유지)
            for (int i = n - 1; i >= 0; i--) {
                int digit = (array[i] / exp) % 10;
                output[--count[digit]] = array[i];
            }

            // 정렬된 값을 원본 배열로 복사
            System.arraycopy(output, 0, array, 0, n);

            // 다음 자리수로 이동
            exp *= 10;
        }
    }

}
