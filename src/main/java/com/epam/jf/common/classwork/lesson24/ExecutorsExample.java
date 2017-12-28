package com.epam.jf.common.classwork.lesson24;

import java.util.concurrent.*;

public class ExecutorsExample {



    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
//        Runnable runnable = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("1 task");
//        };
//        service.execute(runnable);
//        service.execute(runnable);
//        service.execute(runnable);
//        service.execute(runnable);
//        service.shutdown();

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        };

        Future<Integer> submit = service.submit(task);
        System.out.println(submit.isDone());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
//        List<Runnable> runnables = service.shutdownNow();
//        System.out.println(runnables);
    }
}
