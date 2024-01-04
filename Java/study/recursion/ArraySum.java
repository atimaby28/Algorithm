package recursion;

public class ArraySum {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int idx = 0;
        int sum = 0;
        int totalSum = ArrSum(arr, idx, sum);

        System.out.println(totalSum);

        int n = 10;
        int sumN = ArrSum2(arr, n);

        System.out.println(sumN);

    }

    // 오름차순 Recursion
    private static int ArrSum(int[] arr, int idx, int sum) {
        if(idx == arr.length) {
            return sum;
        }

        sum += arr[idx];

        return ArrSum(arr, idx + 1, sum);
    }

    // 내림차순 Recursion
    private static int ArrSum2(int[] arr, int n) {
        if(n <= 0) {
            return 0;
        }

        return ArrSum2(arr, n - 1) + arr[n - 1];
    }

}
