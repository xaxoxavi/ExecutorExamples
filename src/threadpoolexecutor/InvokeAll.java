package threadpoolexecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class InvokeAll {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        RandomCallable rc1 = new RandomCallable();
        RandomCallable rc2 = new RandomCallable();
        RandomCallable rc3 = new RandomCallable();
        RandomCallable rc4 = new RandomCallable();
        RandomCallable rc5 = new RandomCallable();
        
        List<Callable> callables = new ArrayList();
        
        callables.add(rc1);
        callables.add(rc2);
        callables.add(rc3);
        callables.add(rc4);
        callables.add(rc5);
        
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        System.out.println("Executes task");
        
        List<Future<Double>> futures = executor.invokeAll((Collection)callables);
        
             
        Future<Double> future1 = futures.get(0);
        
        Double result = future1.get();
        
        System.out.println("Readed value: " + result);
        
        executor.shutdown();
             
        
    }
    
}
