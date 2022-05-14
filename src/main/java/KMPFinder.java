import java.io.File;
import java.nio.charset.StandardCharsets;

public class KMPFinder implements FindSubStringInterface {
    public Boolean flagExist;


    @Override
    public void algorithm(byte[] allBytes, String patternFromArgs, String typeFile, File file) {
        flagExist = false;
        byte[] pattern = patternFromArgs.getBytes(StandardCharsets.UTF_8);
        int[] p = prefixFunctionForByte(pattern);
        int k = 0;
        int j = 0;
        int m = 0;
        while (k != pattern.length) {
            for (int i = j; i < allBytes.length; i++) {
                if (allBytes[i] == pattern[k]) {
                    k++;
                    if (k == pattern.length) {
                        flagExist = true;
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
                flagExist = false;
                break;
            }
        }

    }
}
