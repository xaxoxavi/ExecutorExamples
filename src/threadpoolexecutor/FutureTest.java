package threadpoolexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        RandomCallable rc1 = new RandomCallable(10000L);
        RandomCallable rc2 = new RandomCallable(5000L);
        RandomCallable rc3 = new RandomCallable(20000L);
        RandomCallable rc4 = new RandomCallable();
        RandomCallable rc5 = new RandomCallable();

        List<Callable> callables = new ArrayList();

        callables.add(rc1);
        callables.add(rc2);
        callables.add(rc3);
        callables.add(rc4);
        callables.add(rc5);

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future> futureList = new ArrayList<>();

        for (Callable callable : callables) {

            Future<Double> future = executor.submit(callable);
            futureList.add(future);
        }

        System.out.println("*****************  I'M HERE !!!!!!!!!");

        boolean searchFuture = true;
        Double result = null;
        while (searchFuture) {

            for (Future future : futureList) {

                if (future.isDone()) {
                    searchFuture = false;
                    result = (Double) future.get();

                    break;
                }
            }
        }

        System.out.println(" RESULT " + result);

        Double result1 = (Double) futureList.get(0).get();

        System.out.println("THREAD 1 RESULT " + result1);

        executor.shutdown();

    }

}
