package futureexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Melike Geçer
 */
public class FactorialFuture {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculateFactorial(Integer number) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            int fact = 1;

            for (int i = 1; i <= number; i++) {
                fact *= i;
            }

            return fact;
        });
    }
}
