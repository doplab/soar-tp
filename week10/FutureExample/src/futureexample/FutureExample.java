package futureexample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author Melike Geçer
 */
public class FutureExample {

    public static void main(String[] args) {
        System.out.println("1");
        FactorialFuture ff = new FactorialFuture();

        Future<Integer> f1 = ff.calculateFactorial(4);
        Future<Integer> f2 = ff.calculateFactorial(6);
        try {
            while (!(f1.isDone() && f2.isDone())) {
                if (f1.isDone()) {
                    System.out.println("Future 1 is done!");
                } else {
                    System.out.println("Future 1 is NOT done!");
                }

                if (f2.isDone()) {
                    System.out.println("Future 2 is done!");
                } else {
                    System.out.println("Future 2 is NOT done!");
                }
                Thread.sleep(300);
            }

            Integer result1 = f1.get();
            Integer result2 = f2.get();

            System.out.println(result1 + " and " + result2);
            System.exit(0);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } catch (ExecutionException ex) {
            System.out.println(ex);
        }
    }

}
