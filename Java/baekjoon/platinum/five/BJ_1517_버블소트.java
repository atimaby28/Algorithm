package platinum.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1517_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(nums);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    public static long solution(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static long mergeSort(int[] arr, int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // 왼쪽 부분 정렬 및 역순 쌍 계산
            invCount += mergeSort(arr, left, mid);

            // 오른쪽 부분 정렬 및 역순 쌍 계산
            invCount += mergeSort(arr, mid + 1, right);

            // 병합 및 역순 쌍 계산
            invCount += merge(arr, left, mid, right);
        }

        return invCount;
    }

    private static long merge(int[] array, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];

        int leftAreaIdx = left;      // 왼쪽 배열의 시작
        int rightAreaIdx = mid + 1;   // 오른쪽 배열의 시작

        int auxIdx = 0;      // 병합된 배열의 시작

        long invCount = 0;

        // 병합하면서 역순 정렬 쌍 계산
        while (leftAreaIdx <= mid && rightAreaIdx <= right) {
            if (array[leftAreaIdx] <= array[rightAreaIdx]) {
                aux[auxIdx++] = array[leftAreaIdx++];
            } else {
                aux[auxIdx++] = array[rightAreaIdx++];
                invCount += (mid - leftAreaIdx + 1); // i부터 mid까지의 모든 원소가 arr[j]보다 큼
            }
        }

        // 남아있는 왼쪽 부분 복사
        while (leftAreaIdx <= mid) {
            aux[auxIdx++] = array[leftAreaIdx++];
        }

        // 남아있는 오른쪽 부분 복사
        while (rightAreaIdx <= right) {
            aux[auxIdx++] = array[rightAreaIdx++];
        }

        // temp 배열을 원본 배열로 복사
        System.arraycopy(aux, 0, array, left, aux.length);

        return invCount;
    }
}
