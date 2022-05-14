import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Part_1 {
//    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) throws FileNotFoundException {

        // File path = new File("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc44.pdf");
//        System.out.println(path);
//        System.out.println(args[1]);
//        System.out.println(Arrays.toString(args[1].getBytes(StandardCharsets.UTF_8)));
//
//        System.out.println(args[1]);

        try (
                FileInputStream inputStream = new FileInputStream(args[0]);
        ) {

//            System.out.printf("File size: %d bytes \n", inputStream.available());
            byte[] allBytes = inputStream.readAllBytes();
            // byte[] allBytes = Files.readAllBytes(Path.of("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc44.pdf"));
            //Files.readAllBytes(Path.of("C:\\Users\\Tanya\\Desktop\\untitled\\Hello\\src\\File_Type_Analyzer\\doc44.pdf"));
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
            String str = new String(allBytes, StandardCharsets.UTF_8);
            if (str.contains(args[1])) {
                System.out.println(args[2]);
            } else {
                System.out.println("Unknown file type");
            }
//            System.out.println(Arrays.toString(allBytes));
//            System.out.println(Arrays.toString(allBytes).contains("%PDF-"));
//            List<String> list1 = Collections.singletonList(Arrays.toString(allBytes));
//            List<String> list2 = Collections.singletonList(Arrays.toString(k));
//            int[] headerBytes = new int[inputStream.available()];
//            boolean isPNG = true;

//            System.out.println(Arrays.toString(allBytes));
//            System.out.println(isPNG);

//            System.out.println(Collections.indexOfSubList(List.of(allBytes), List.of(k)));
//            System.out.println(list1.containsAll(list2));
//            System.out.println(Collections.indexOfSubList(list1, list2));


        } catch (IOException e) {
            e.printStackTrace();
        }


//            System.out.println(Collections.indexOfSubList(List.of(allBytes), List.of(k)));
//        int[] headerBytes = new int[8];
//
//        boolean isPNG = true;
//
//        System.out.println(isPNG);
    }
}
