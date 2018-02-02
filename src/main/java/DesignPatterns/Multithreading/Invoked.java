package DesignPatterns.Multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Invoked {

    private final static Logger LOGGER = LoggerFactory.getLogger(Invoked.class);

    static {
        System.out.println("inside static before start");
        new Thread(() -> {
//            try {
                System.out.println("slipping ... ");
                LOGGER.info("abc");
                throw new RuntimeException();
//                System.out.println("slipped");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start();
        System.out.println("inside static after start");
    }
}
