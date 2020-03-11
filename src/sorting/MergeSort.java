package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        int unorderedPairCount = getUnorderedPairCount(array);

        System.out.println(unorderedPairCount);
    }

    private static int getUnorderedPairCount(int[] array) {

        int start = 0;
        int end = array.length - 1;

        int unorderedPairCount = merge(array, start, end);

        return unorderedPairCount;
    }

    private static int merge(int[] array, int start, int end) {

        if (start == end) {
            return 0;
        }

        int mid = (end + start) / 2;

        int leftUnorderedPairs = merge(array, start, mid);
        int rightUnorderedPairs = merge(array, mid + 1, end);

        int leftIndex = start;
        int rightIndex = mid + 1;

        int[] resultArray = new int[end - start + 1];

        int resultIndex = 0;

        int unorderedPairCount = 0;

        while (leftIndex <= mid  || rightIndex <= end ) {

            if (leftIndex <= mid && (rightIndex > end || array[leftIndex] < array[rightIndex])) {

                resultArray[resultIndex] = array[leftIndex];

                leftIndex++;

            } else {

                unorderedPairCount += (mid - leftIndex + 1);

                resultArray[resultIndex] = array[rightIndex];

                rightIndex++;
            }

            resultIndex++;
        }

        resultIndex = 0;

        for (int i = start; i <= end; i++) {

            array[i] = resultArray[resultIndex];

            resultIndex++;
        }

        return leftUnorderedPairs + rightUnorderedPairs + unorderedPairCount;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
