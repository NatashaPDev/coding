import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Search {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        Arrays.sort(array);

        int queryCount = reader.nextInt();

        for (int i = 0; i < queryCount; i++) {

            int queryType = reader.nextInt();

            int x = reader.nextInt();

            int numberCount = countNumbers(queryType, x, array);

            System.out.println(numberCount);
        }
    }

    private static int countNumbers(int queryType, int x, int[] array) {

        switch (queryType) {

            case 0:
                return countNotLessNumbers(x, array);

            case 1:
                return countGreaterNumbers(x, array);

            default:
                throw new RuntimeException("Unknown query type.");
        }
    }

    private static int countGreaterNumbers(int x, int[] sortedArray) {

        int count = 0;

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (sortedArray[mid] > x) {

                count += (high - mid + 1);
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return count;
    }

    private static int countNotLessNumbers(int x, int[] sortedArray) {

        int count = 0;

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (sortedArray[mid] >= x) {

                count += (high - mid + 1);
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return count;
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
