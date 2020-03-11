import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinearSearch {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int numberForSearch = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = reader.nextInt();
        }

        int index = search(array, numberForSearch);

        System.out.println(index);
    }

    private static int search(int[] array, int number) {

        int numberIndex = -1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == number) {
                numberIndex = i + 1;
            }
        }

        return numberIndex;
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
