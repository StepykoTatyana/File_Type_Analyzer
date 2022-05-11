import java.io.File;

public interface FindSubStringInterface {
    void algorithm(byte[] allBytes, String arg1, String arg2, File file);

    default int[] prefixFunctionForByte(byte[] s) {
        int[] p = new int[s.length];
        int k = 0;
        for (int i = 1; i < s.length; i++) {
            while (k > 0 && s[k] != s[i]) {
                k = p[k - 1];
            }
            if (s[k] == s[i]) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }
}
