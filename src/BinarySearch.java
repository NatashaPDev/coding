import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = reader.nextInt();
        }

        Arrays.sort(array);

        int queryCount = reader.nextInt();

        for (int i = 0; i < queryCount; i++) {

            int numberForSearch = reader.nextInt();

            int index = binarySearch(array, numberForSearch);

            System.out.println(index);
        }
    }

    private static int binarySearch(int[] array, int number) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (number == array[mid]) {
                return mid + 1;
            }

            if (number < array[mid]) {
                high = mid - 1;
            }

            if (number > array[mid]) {
                low = mid + 1;
            }
        }

        return -1;
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
