import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Part_3Clear {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int THREADS = 10; // кол-во потоков
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        String path = args[0];
        String pattern = args[1];
        String typeFile = args[2];
        File file = new File("C:\\Apps\\IdeaProjects\\File_Type_Analyzer\\src\\main\\java\\" + path);
        File[] files = file.listFiles();
        List<Callable<Object>> tasks = new ArrayList<>();


        assert files != null;
        for (File f : files) {
            tasks.add(new Callable<Object>() {
                public Object call() throws Exception {
                    FindSubStringClass.findSubStringNew(f, pattern, typeFile);
                    return null;
                }
            });
        }
        List<Future<Object>> invokeAll = executor.invokeAll(tasks);
        for (Future<Object> future : invokeAll) {
            future.get();
        }
        executor.shutdown();
    }

}