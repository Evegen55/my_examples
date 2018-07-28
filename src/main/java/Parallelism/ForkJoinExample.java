package Parallelism;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinExample {
    private final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ForkJoinExample().run();
    }

    /**
     * 0123456789, counter = 10
     * 0123456789, counter = 10
     * 0000000000, counter = 1
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private void run() throws ExecutionException, InterruptedException {

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        ExecutorService tpe = Executors.newFixedThreadPool(availableProcessors);
        Callable callable = () -> {
            System.out.println(Thread.currentThread().getName());
            return counter.getAndIncrement();};

        ForkJoinPool fjp = new ForkJoinPool(availableProcessors);
        RecursiveTask task = new RecursiveTask() {
            @Override
            protected Object compute() {
                System.out.println(Thread.currentThread().getName());
                return counter.getAndIncrement();
            }
        };

        System.out.println("\n============================");
        counter.set(0);
        for (int c = 0; c < 10; c++) {
            System.out.print(tpe.submit(callable).get() + "\t");
        }
        System.out.println(", counter = " + counter.get());

        System.out.println("\n============================");
        counter.set(0);
        for (int c = 0; c < 10; c++) {
            System.out.print(fjp.submit(callable).get() + "\t");
        }
        System.out.println(", counter = " + counter.get());

        System.out.println("\n============================");
        counter.set(0);
        for (int c = 0; c < 10; c++) {
            System.out.print(fjp.submit(task).get() + "\t");
        }
        System.out.println(", counter = " + counter.get());

        tpe.shutdownNow();
        fjp.shutdownNow();
    }

}
