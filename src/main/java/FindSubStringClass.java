import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class FindSubStringClass {
    static private String typeAlgorithm;
    static String path;
    static File file;
    static String pattern;
    static String typeFile;


    public FindSubStringClass(String typeAlgorithm, String path, String pattern, String typeFile) {
        FindSubStringClass.typeAlgorithm = typeAlgorithm;
        FindSubStringClass.path = path;
        FindSubStringClass.pattern = pattern;
        FindSubStringClass.typeFile = typeFile;
    }

    protected void findSubString() {
//        System.out.println(typeAlgorithm);
//        System.out.println(path);
//        System.out.println(pattern);

        try (

                FileInputStream inputStream = new FileInputStream(path);
        ) {
            byte[] allBytes = inputStream.readAllBytes();
            if (Objects.equals(typeAlgorithm, "--naive")) {
                FindSubStringInterface naiveFinder = new NaiveFinder();
                naiveFinder.algorithm(allBytes, pattern, typeFile, null);
            } else {
                KMPFinder kmpFinder = new KMPFinder();
                if (file != null) {
                    kmpFinder.algorithm(allBytes, pattern, typeFile, file);
                } else {
                    kmpFinder.algorithm(allBytes, pattern, typeFile, null);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findSubStringNew(File file, String pattern, String typeFile) {
        try (

                FileInputStream inputStream = new FileInputStream(file.getPath());
        ) {
            byte[] allBytes = inputStream.readAllBytes();
            if (Objects.equals(typeAlgorithm, "--naive")) {
                FindSubStringInterface naiveFinder = new NaiveFinder();
                naiveFinder.algorithm(allBytes, pattern, typeFile, null);
            } else {
                KMPFinder kmpFinder = new KMPFinder();
                kmpFinder.algorithm(allBytes, pattern, typeFile, file);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
