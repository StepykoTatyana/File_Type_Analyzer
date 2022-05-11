import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Part_2 {
//    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) throws FileNotFoundException {

        // File path = new File("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc.pdf");
//        System.out.println(path);
//        System.out.println(args[1]);
//        System.out.println(Arrays.toString(args[1].getBytes(StandardCharsets.UTF_8)));
//
//        System.out.println(args[1]);

        try (
                FileInputStream inputStream = new FileInputStream("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc.pdf");
        ) {

//            System.out.printf("File size: %d bytes \n", inputStream.available());
            //byte[] allBytes = inputStream.readAllBytes();
            // byte[] allBytes = Files.readAllBytes(Path.of("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc.pdf"));
            //Files.readAllBytes(Path.of("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc.pdf"));
//            System.out.println("@@@@@@@@@@@@@@@");
//            System.out.println(args[1]);
//            byte[] k = args[1].getBytes(StandardCharsets.UTF_8);
//            String format = "%PDF-";
//            System.out.println(Arrays.toString(format.getBytes(StandardCharsets.UTF_8)));

//            int i = -1;
//            while ((i = inputStream.read()) != -1) {
////                System.out.println(i);
////                System.out.println( (char) i);
//
//            }
            //String str = new String(allBytes, StandardCharsets.UTF_8);
            //byte[] s = "ABCABCAABCABD".getBytes(StandardCharsets.UTF_8);
//            String st = "ABCABDF";
            byte[] allBytes = inputStream.readAllBytes();
//            System.out.println(Arrays.toString(s));
            if (Objects.equals(args[0], "--naive")) {
                firstAlgorithm(allBytes, args[2], args[3]);
            } else {
                secondAlgorithmForByte(allBytes, args[2], args[3]);
            }

//            int[] p = prefixFunction(st);
//            String text = "ABCABCAABCABDAB";
            //System.out.println(Arrays.toString(p));
//            System.out.println(text.length());
//            int k = 0;
//            int j = 0;
//            int m = 0;
//            while (k != st.length()) {
//                if (m > text.length()) {
//                    System.out.println("Unknown file type");
//                    break;
//                }
//                for (int i = j; i < text.length(); i++) {
//                    if (k == st.length()) {
//                        System.out.println(args[2]);
//                        break;
//                    }
//                    if (text.charAt(i) == st.charAt(k)) {
////                        System.out.println(text.charAt(i));
////                        System.out.println(st.charAt(k));
////                        System.out.println(i);
////                        System.out.println(k);
//                        ++k;
//                    } else {
//                        if (k - 1 < 0) {
//                            j = j + (k - p[0]);
//                            // System.out.println(p[0]);
//                        } else {
//                            j = j + (k - p[k - 1]);
//                            //System.out.println(p[k - 1]);
//                        }
////                        System.out.println(k);
////                        System.out.println(Arrays.toString(p));
////                        System.out.println(i);
////                        System.out.println("j " + j);
//                        k = 0;
//                        break;
//                    }
//
//                }
//                //System.out.println(k);
//                m++;
//                //System.out.println(m);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = p[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }

    public static int[] prefixFunctionForByte(byte[] s) {
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

    public static void firstAlgorithm(byte[] allBytes, String arg1, String arg2) throws IOException {
        byte[] pattern = arg1.getBytes(StandardCharsets.UTF_8);
//        System.out.println(Arrays.toString(pattern));
        // ПЕРВЫЙ АЛГОРИТМ
        int k = 0;
        long startTime = System.nanoTime();
//        System.out.println(Arrays.toString(pattern));
//        System.out.println(Arrays.toString(allBytes));
//        File file = new File(".\\src\\File_Type_Analyzer\\test3.txt");
//        try(FileReader fileReader = new FileReader(file.toString())){
//            int bytes = fileReader.;
//            System.out.println(bytes[0]);
//        } catch (IOException e) {
//            System.out.printf("An exception occurred %s", e.getMessage());
//        }
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(Arrays.toString(allBytes));
//        } catch (IOException e) {
//            System.out.printf("An exception occurred %s", e.getMessage());
//        }
        int j = 0;
        int m = 0;
        while (k != pattern.length) {
            if (allBytes[j] == pattern[k]) {
                k++;
                j++;
                if (k == pattern.length) {
                    System.out.println(arg2);
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
    }


    public static void secondAlgorithm(FileInputStream inputStream, String arg) {
        String st = "ABCABDF";
        int[] p = prefixFunction(st);
        String text = "ABCABCAABCABD";
        int k = 0;
        int j = 0;
        int m = 0;
        long startTime = System.nanoTime();
        while (k != st.length()) {
            if (m > text.length()) {
                System.out.println("Unknown file type");
                long elapsedNanos = System.nanoTime() - startTime;
                System.out.printf("It took %d seconds", elapsedNanos / 1_000_000_000);
                break;
            }
            for (int i = j; i < text.length(); i++) {
                if (k == st.length()) {
                    System.out.println(arg);
                    long elapsedNanos = System.nanoTime() - startTime;
                    System.out.printf("It took %d seconds", elapsedNanos / 1_000_000_000);
                    break;
                }
                if (text.charAt(i) == st.charAt(k)) {
                    ++k;
                } else {
                    if (k - 1 < 0) {
                        j = j + (k - p[0]);
                    } else {
                        j = j + (k - p[k - 1]);
                    }
                    k = 0;
                    break;
                }
            }
            m++;
        }
    }


    public static void secondAlgorithmForByte(byte[] allBytes, String arg1, String arg2) {
        byte[] pattern = arg1.getBytes(StandardCharsets.UTF_8);
        int[] p = prefixFunctionForByte(pattern);
        int k = 0;
        int j = 0;
        int m = 0;
        long startTime = System.nanoTime();


//        File file = new File(".\\src\\File_Type_Analyzer\\test2.txt");
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(Arrays.toString(allBytes));
//        } catch (IOException e) {
//            System.out.printf("An exception occurred %s", e.getMessage());
//        }

        while (k != pattern.length) {
            for (int i = j; i < allBytes.length; i++) {
                if (allBytes[i] == pattern[k]) {
                    k++;
                    if (k == pattern.length) {
                        System.out.println(arg2);
                        long elapsedNanos = System.nanoTime() - startTime;
                        System.out.printf("It took %.3f seconds", (float) elapsedNanos / 1_000_000_000);
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
                break;
            }
        }
    }
}


