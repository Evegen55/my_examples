package HKUST.CarIntro;

import org.junit.Test;

/**
 * Created by Evegen on 18.11.2016.
 */
public class CarTest {
    @Test
    public void move() throws Exception {

    }

    @Test
    public void moveCar() throws Exception {

    }

    @Test
    public void turnCar() throws Exception {

    }

    @Test
    public void pause() throws Exception {

    }

    public static void main(String[] args) {
        Car target=new Car("nameOfOwner");
        //we might getting it from console
        target.move(100);
        target.moveCar(100);
        target.turnCar(50);
        target.pause(100);
    }

}