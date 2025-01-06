package level3.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_표현가능한이진트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] numbers = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int treeDepth = calculateDepth(binary.length());
            String paddedBinary = padBinary(binary, treeDepth);

            if (isValidTree(paddedBinary, 0, paddedBinary.length() - 1)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    // 트리의 높이를 계산, 2^h - 1 : 트리의 전체 노드 수 (포화 이진 트리)
    private static int calculateDepth(int length) {
        int height = 0;

        while ((1 << height) - 1 < length) {
            height++;
        }

        return height;
    }

    // 포화 이진트리가 아닌경우 포화 이진트리를 만들기 위해 '0'을 패딩처리
    private static String padBinary(String binary, int depth) {
        int fullLength = (1 << depth) - 1; // 전체 길이

        StringBuilder padded = new StringBuilder();

        for (int i = 0; i < fullLength - binary.length(); i++) {
            padded.append("0");
        }

        padded.append(binary);

        return padded.toString();
    }

    // 중간 노드(mid)를 루트로 가정, 왼쪽 및 오른쪽 서브트리를 재귀적으로 확인
    private static boolean isValidTree(String binary, int left, int right) {
        if (left > right) return true;

        int mid = (left + right) / 2;
        char root = binary.charAt(mid);

        // 루트 노드가 '0'일 때, 하위 노드가 '1'이면 유효하지 않은 트리로 판단
        if (root == '0') {
            for (int i = left; i <= right; i++) {
                if (binary.charAt(i) == '1') return false;
            }
        }

        return isValidTree(binary, left, mid - 1) && isValidTree(binary, mid + 1, right);
    }

}
