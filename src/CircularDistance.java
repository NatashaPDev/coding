import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CircularDistance {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int pointCount = reader.nextInt();

        double[] pointDistance = new double[pointCount];

        for (int i = 0; i < pointCount; i++) {

            long x = reader.nextLong();
            long y = reader.nextLong();

            pointDistance[i] = Math.sqrt(Math.pow(x, 2) + (long) Math.pow(y, 2));
        }

        int queryCount = reader.nextInt();

        Arrays.sort(pointDistance);

        for (int i = 0; i < queryCount; i++) {

            long radius = reader.nextLong();

            int insidePointCount = countInsidePoints(pointDistance, radius );

            System.out.println(insidePointCount);
        }
    }

    private static int countInsidePoints(double[] pointDistance, long radius) {

        int low = 0;
        int high = pointDistance.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (pointDistance[mid] == radius) {

                high = mid;
                break;
            }

            if (pointDistance[mid] > radius) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return high + 1;
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
