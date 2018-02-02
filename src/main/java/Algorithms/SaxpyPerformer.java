package Algorithms;

import java.time.Duration;
import java.time.Instant;

public class SaxpyPerformer {

    static int N = 1_000_000;

    public static void main(String[] args) {

        // Perform SAXPY on 1M elements for 1000 times
        float[] res = new float[0];
        Instant sortStart = Instant.now();

        for (int i = 0; i < 1000; i++){
            res = doSaxpy();
        }

        Instant sortEnd = Instant.now();

        System.out.println(res[0] + "\t" + res[N-1]);
        // display timing results
        long sortTime = Duration.between(sortStart, sortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n%n", sortTime);
    }

    private static float[] doSaxpy() {
        float[] x = new float[N];
        float[] y = new float[N];
        float[] result = new float[N];
        //initialize arrays
        for (int i = 0; i < N; i++) {
            x[i] = 1.0f;
            y[i] = 2.0f;
        }

        saxpy(N, 2.0f, x, y, result);
        return result;
    }

    private static void saxpy(int n, float a, float[] x, float[] y, float[] z) {
        for (int i = 0; i < n; ++i) {
            z[i] = a * x[i] + y[i];
        }
    }
}
