import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class RabinKarpFinder implements FindSubStringInterface {

    public Boolean flagExist;

    @Override
    public void algorithm(byte[] allBytes, String patternFromArgs, String typeFile, File file) {
        flagExist = false;
        byte[] pattern = patternFromArgs.getBytes(StandardCharsets.UTF_8);
        int lengthPattern = pattern.length;
        int hashCode = Arrays.hashCode(pattern);
        int currentLength = allBytes.length;
        int i = 0;
        while (currentLength > lengthPattern) {
            currentLength = allBytes.length - i;
            try {
                byte[] currentSubString = Arrays.copyOfRange(allBytes,
                        currentLength - lengthPattern, currentLength);
                int hashCodeCurrentSubString = Arrays.hashCode(currentSubString);
                if (hashCode == hashCodeCurrentSubString) {
                    for (int k = 0; k < pattern.length; k++) {
                        flagExist = pattern[k] == currentSubString[k];
                    }
                    if (flagExist) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            } catch (Exception ignored) {

            }


        }


    }
}


