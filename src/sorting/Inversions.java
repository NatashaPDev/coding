package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inversions {

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

    public static void main(String[] args) {

        FastReader s = new FastReader();

        int dimension = s.nextInt();

        int[] array = new int[dimension];

        int index = 0;

        while (index < dimension ) {

            array[index] = s.nextInt();

            index++;
        }

        int inversionCount = getInversionCount(array);

        System.out.println(inversionCount);

    }


    private static int getInversionCount(int[] array) {

        boolean sorted = false;

        int inversionCount = 0;

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {

                    inversionCount++;

                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    sorted = false;
                }
            }
        }

        return inversionCount;
    }
}

