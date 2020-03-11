import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TernarySearch {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int intervalCount = reader.nextInt();

        for (int i = 0; i < intervalCount; i++) {

            int leftEdge = reader.nextInt();
            int rightEdge = reader.nextInt();

            long min = Math.round(ternarySearch(leftEdge, rightEdge));

            System.out.println(min);
        }
    }

    private static double ternarySearch(double leftEdge, double rightEdge) {

        for (int i = 0; i < 100; i++) {

            double leftBorder = leftEdge + (rightEdge - leftEdge) / 3;
            double rightBorder = leftEdge + (leftBorder - leftEdge) * 2;

            if (function(leftBorder) < function(rightBorder)) {
                rightEdge = rightBorder;

            } else {
                leftEdge = leftBorder;
            }
        }

        return function(rightEdge);
    }

    private static double function(double x) {

        return 2 * x * x - 12 * x + 7;
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
