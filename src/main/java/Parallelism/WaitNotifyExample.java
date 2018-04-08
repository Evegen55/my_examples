package Parallelism;

public class WaitNotifyExample {

    public static void main(String[] args) {

        final Object mutex = new Object();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting for signal");
            synchronized (mutex) {
                try {
                    mutex.wait(); //waiting signal by using mutex object
                    System.out.println(name + " got it");
                } catch (Exception e) {
                    System.out.println(name + " interrupted");
                }
                System.out.println("finished");
            }
        }).start();



        String name1 = Thread.currentThread().getName();
        System.out.println(name1 + " thread is sleeping....");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name1 + " thread started and sending a signal");

        synchronized (mutex) {
            mutex.notify();
        }

    }
}
