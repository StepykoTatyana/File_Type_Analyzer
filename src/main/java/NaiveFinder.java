import java.nio.charset.StandardCharsets;

public class NaiveFinder implements FindSubStringInterface{
    @Override
    public void algorithm(byte[] allBytes, String patternFromArgs, String typeFile) {
        byte[] pattern = patternFromArgs.getBytes(StandardCharsets.UTF_8);
        int k = 0;
        long startTime = System.nanoTime();
        int j = 0;
        int m = 0;
        while (k != pattern.length) {
            if (allBytes[j] == pattern[k]) {
                k++;
                j++;
                if (k == pattern.length) {
                    System.out.println(typeFile);
                    break;
                }
            } else {
                j = m++;
                k = 0;
                if (j >= allBytes.length) {
                    System.out.println("Unknown file type");
                    break;
                }
            }

        }
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.printf("It took %.3f seconds", (float) elapsedNanos / 1_000_000_000);
        System.out.println();
    }
}
