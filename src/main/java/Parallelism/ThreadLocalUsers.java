package Parallelism;

public class ThreadLocalUsers {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            int i = ThreadId.get();
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        });

        Thread thread2 = new Thread(() -> {
            int i = ThreadId.get();
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        });

        Thread thread3 = new Thread(() -> {
            int i = ThreadId.get();
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
