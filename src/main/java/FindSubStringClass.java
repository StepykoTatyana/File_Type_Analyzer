import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class FindSubStringClass {
    static private String typeAlgorithm;
    static String path;
    static String pattern;
    static String typeFile;


    public  FindSubStringClass(String typeAlgorithm, String path, String pattern, String typeFile){
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
                FileInputStream inputStream = new FileInputStream("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\"+ path);
        ) {
            byte[] allBytes = inputStream.readAllBytes();
            if (Objects.equals(typeAlgorithm, "--naive")) {
                FindSubStringInterface naiveFinder = new NaiveFinder();
                naiveFinder.algorithm(allBytes, pattern, typeFile);
            } else {
                File_Type_Analyzer.KMPFinder kmpFinder = new File_Type_Analyzer.KMPFinder();
                kmpFinder.algorithm(allBytes,pattern, typeFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    @Override
//    public void run() {
//        findSubString();
//    }
}
