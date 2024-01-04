package recursion;

// 매개변수의 명시화하여 재귀함수를 작성하여야 한다.
public class TargetSearch {

    public static void main(String[] args) {

        int[] data = {4, 7, 1, 8, 32, 25, 2, 6, 72, 31};

        int isFindIdx = searchTarget(data, data.length, 8);

        System.out.println(isFindIdx);

        int isFindIdx1 = searchTargetOrder(data, 4, data.length, 72);

        System.out.println(isFindIdx1);

        int isFindIdx2 = searchTargetReverse(data, 2, data.length - 3, 32);

        System.out.println(isFindIdx2);

        int isFindIdx3 = searchFromMiddle(data, 0, data.length, 25);

        System.out.println(isFindIdx3);

    }

    // 이 함수는 시작 인덱스가 0이라는 암시적 매개변수의 뜻을 갖고 있다.
    private static int searchTarget(int[] data, int n, int target) {
        for (int i = 0; i < n; i++) {
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 그렇지만 재귀함수는 시작 index와 끝 index를 명시적으로 밝히는 것이 좋다.
    private static int searchTargetOrder(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        } else if (target == data[begin]) {
            return begin;
        } else {
            return searchTargetOrder(data, begin + 1, end, target);
        }

    }

    private static int searchTargetReverse(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        } else if (target == data[end]) {
            return end;
        } else {
            return searchTargetReverse(data, begin, end - 1, target);
        }

    }

    private static int searchFromMiddle(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        }

        int middle = (begin + end) / 2;

        // 중간 값이 찾는 index라면 그대로 return
        if (data[middle] == target) {
            return middle;
        }

        // 앞쪽 부분을 탐색하는 재귀
        int index = searchFromMiddle(data, begin, middle - 1, target);

        // 앞쪽에서 인덱스를 찾았다면 그대로 return
        if (index != -1) {
            return index;
        }

        // 뒤쪽 부분을 탐색하는 재귀
        return searchFromMiddle(data, middle + 1, end, target);


    }

}
