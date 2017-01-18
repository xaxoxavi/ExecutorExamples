package threadpoolexecutor;


import java.util.concurrent.Callable;


public class RandomCallable implements Callable<Double>{
    
    private Long minimTime;
    
     public RandomCallable(){
         this.minimTime = 2000L;
     }
    
    public RandomCallable(Long minimTime){
        this.minimTime = minimTime;
    }

    @Override
    public Double call() throws Exception {
        
        double timeToWait =  Math.random() * 1000L;
        long totalTime = minimTime + (long)timeToWait;
        Thread.sleep(totalTime);
        
        System.out.println(Thread.currentThread().getName() + " -> " + totalTime);
        return timeToWait;
    }
    
}
