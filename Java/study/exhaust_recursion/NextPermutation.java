package exhaust_recursion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutation {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        // 입력받은 수를 배열에 저장.
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 순열.
        nextPermutation();

        bw.flush();
        bw.close();
    }

    private static void nextPermutation() {
        // 주어진 순열의 뒤부터 탐색하며, 증가하는 부분을 찾는다.
        int idx = N - 1;
        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                idx = i;
                break;
            }
        }

        // 만일, 증가하는 부분이 존재하지 않으면 다음 순열은 존재하지 않는 것이다.
        if (idx == 0) {
            System.out.println("다음 순열이 존재하지 않습니다. 마지막 순열 입니다.");
            return;
        }

        // 해당 인덱스를 기준으로, 좌/우지점을 나눈다.
        // 좌측의 제일 오른쪽 숫자에 대하여, 우측의 제일 오른쪽 지점부터 탐색하며 큰 수를 찾는다.
        // 해당 숫자를 찾았다면 각 숫자를 서로 Swap한다.
        for (int i = N - 1; i >= idx; i--) {
            if (arr[idx - 1] < arr[i]) {
                int temp = arr[idx - 1];
                arr[idx - 1] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        // 우측 지점을 정렬한다.
        Arrays.sort(arr, idx, N);

        // 결과 출력
        System.out.println(Arrays.toString(arr));
    }
}