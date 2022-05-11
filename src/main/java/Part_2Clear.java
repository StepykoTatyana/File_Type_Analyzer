import java.io.FileNotFoundException;
import java.util.concurrent.*;

public class Part_2Clear {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future  = executor.submit(() -> {
                    FindSubStringClass findSubStringClass = new FindSubStringClass(args[0], args[1], args[2], args[3]);
                    findSubStringClass.findSubString();
                    FindSubStringClass findSubStringClass1 = new FindSubStringClass(args[4], args[5], args[6], args[7]);
                    findSubStringClass1.findSubString();

                }

        );
        future.get(10, TimeUnit.SECONDS);
        boolean terminated = executor.awaitTermination(60, TimeUnit.MILLISECONDS);
        executor.shutdown();

    }
}
