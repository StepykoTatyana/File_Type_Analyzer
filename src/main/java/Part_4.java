import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

public class Part_4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int THREADS = 10; // кол-во потоков
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        String path = args[0];
        File file = new File("C:\\Apps\\IdeaProjects\\File_Type_Analyzer\\src\\main\\java\\" + path);
        File filePatterns = new File("C:\\Apps\\IdeaProjects\\File_Type_Analyzer\\src\\main\\resources\\patterns.db");
        File[] files = file.listFiles();
        List<Callable<Object>> tasks = new ArrayList<>();


        tasks.add(() -> {
            assert files != null;
            for (File f : files) {
                FindSubStringClass.findSubStringV4(f, filePatterns);
            }
            return null;
        });

        List<Future<Object>> invokeAll = executor.invokeAll(tasks);
        for (Future<Object> future : invokeAll) {
            future.get();
        }
        executor.shutdown();
    }

}