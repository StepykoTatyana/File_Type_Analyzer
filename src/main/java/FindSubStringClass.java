import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FindSubStringClass {
    static Boolean flag;
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
        try (
                FileInputStream inputStream = new FileInputStream(path)
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

                FileInputStream inputStream = new FileInputStream(file.getPath())
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

    public static void findSubStringV4(File file, File filePatterns) {
        flag = false;
        SortedMap<Integer, List<String>> ratesMap = new TreeMap<>(Comparator.reverseOrder());
        Map<String, String> mapNamesPatterns = new TreeMap<>();
        try (Scanner scanner = new Scanner(filePatterns)) {
            while (scanner.hasNext()) {
                String[] strings = scanner.nextLine().split(";");
                if (ratesMap.containsKey(Integer.parseInt(strings[0]))) {
                    ratesMap.get(Integer.parseInt(strings[0])).add(strings[1].replace("\"", ""));
                } else {
                    ratesMap.put(Integer.parseInt(strings[0]), new ArrayList<>(Collections.singleton(strings[1].replace("\"", ""))));
                }
                mapNamesPatterns.put(strings[1].replace("\"", ""), (strings[2].replace("\"", "")));

            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "src/FilesDict/file4.txt");
        }


        try (

                FileInputStream inputStream = new FileInputStream(file.getPath())
        ) {
            byte[] allBytes = inputStream.readAllBytes();
            for (List<String> patternList : ratesMap.values()) {
                for (String pattern1 : patternList) {
                    KMPFinder kmpFinder = new KMPFinder();
                    kmpFinder.algorithm(allBytes, pattern1, mapNamesPatterns.get(pattern1), file);
                    flag = kmpFinder.flagExist;
                    if (flag) {
                        System.out.println(file.getName() + ": " + mapNamesPatterns.get(pattern1));
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                System.out.println(file.getName() + ": Unknown file type");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
