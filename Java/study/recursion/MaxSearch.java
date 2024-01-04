package recursion;

public class MaxSearch {
    public static void main(String[] args) {

        int[] data = {4, 7, 1, 8, 32, 25, 2, 6, 72, 31};

        int maxVal = findMax(data, 0, data.length - 3);

        System.out.println(maxVal);

        int maxVal2 = findMax2(data, 0, data.length - 1);

        System.out.println(maxVal2);

    }

    private static int findMax(int[] data, int begin, int end) {
        if(begin == end) {
            return data[begin];
        }

        return Math.max(data[begin], findMax(data, begin + 1, end));
    }

    private static int findMax2(int[] data, int begin, int end) {
        if(begin == end) {
            return data[begin];
        }

        int middle = (begin + end) / 2;

        int max1 = findMax2(data, begin, middle);
        int max2 = findMax2(data, middle + 1, end);

        return Math.max(max1, max2);
    }

}
