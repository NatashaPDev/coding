import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mountains {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int mountainCount = reader.nextInt();

        int queryCount = reader.nextInt();

        int[] mountainLeft = new int[mountainCount];
        int[] mountainRight = new int[mountainCount];

        int heightCount = 0;

        for (int i = 0; i < mountainCount; i++) {

            mountainLeft[i] = reader.nextInt();
            mountainRight[i] = reader.nextInt();

            heightCount += mountainRight[i] - mountainLeft[i] + 1;
        }

        int[] heights = new int[heightCount];

        int heightIndex = 0;

        for (int i = 0; i < mountainCount; i++) {

            for (int j = mountainLeft[i]; j <= mountainRight[i]; j++) {

                heights[heightIndex] = j;

                heightIndex++;
            }
        }

        for (int i = 0; i < queryCount; i++) {

            int query = reader.nextInt();

            int height = heights[query - 1];

            System.out.println(height);
        }
    }

    public static class FastReader {
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
