package DesignPatterns.Multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Invoked {

    private final static Logger LOGGER = LoggerFactory.getLogger(Invoked.class);

    static {
        System.out.println("inside static before start");
        LOGGER.info("WILL NEVER BE PRINTED TOO");
        new Thread(() -> {
//            try {
                System.out.println("slipping ... ");
                LOGGER.info("WILL NEVER BE PRINTED AGAIN");
                throw new RuntimeException();
//                System.out.println("slipped");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start();
        System.out.println("inside static after start");
        LOGGER.info("WILL NEVER BE PRINTED TOO");
    }

    public Invoked() {
        System.out.println("Invoked invoked");
    }
}
