import java.nio.charset.StandardCharsets;

public class KMPFinder implements FindSubStringInterface {
    @Override
    public void algorithm(byte[] allBytes, String patternFromArgs, String typeFile) {
        byte[] pattern = patternFromArgs.getBytes(StandardCharsets.UTF_8);
        int[] p = prefixFunctionForByte(pattern);
        int k = 0;
        int j = 0;
        int m = 0;
        long startTime = System.nanoTime();
        while (k != pattern.length) {
            for (int i = j; i < allBytes.length; i++) {
                if (allBytes[i] == pattern[k]) {
                    k++;
                    if (k == pattern.length) {
                        System.out.println(typeFile);
                        long elapsedNanos = System.nanoTime() - startTime;
                        System.out.printf("It took %.3f seconds", (float) elapsedNanos / 1_000_000_000);
                        System.out.println();
                        break;
                    }
                } else {
                    if (k - 1 < 0) {
                        j = j + 1;
                    } else {
                        j = j + (k - p[k - 1]);
                    }
                    k = 0;
                    break;
                }
            }
            m++;
            if (m > allBytes.length) {
                System.out.println("Unknown file type");
                long elapsedNanos = System.nanoTime() - startTime;
                System.out.printf("It took %.3f seconds", (float) elapsedNanos / 1_000_000_000);
                System.out.println();
                break;
            }
        }
    }
}
