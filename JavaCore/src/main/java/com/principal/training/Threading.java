package com.principal.training;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {
    public static void main(String[] args) {
        // Executor service
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(()-> System.out.println("Hello from thread"));
            service.execute(()-> {
                for (int i=0; i<3; i++){
                    System.out.println("Printing record" + i);
                }
            });
            service.execute(()-> System.out.println("Hello from thread 2"));
            System.out.println("End");
        } finally {
           if(service != null) service.shutdown();
        }

        System.out.println();
        // ThreadPool
        System.out.println("Thread Pool");
        try {
            service = Executors.newFixedThreadPool(20);
            System.out.println("Begin");
            service.submit(()-> System.out.println("Hello from thread"));
            service.submit(()-> {
                for (int i=0; i<3; i++){
                    System.out.println("Printing record" + i);
                }
            });
            service.submit(()-> System.out.println("Hello from thread 2"));
            System.out.println("End");
        } finally {

        }
    }
}
