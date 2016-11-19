package HKUST.CarIntro;

import comp102x.Canvas;
import comp102x.ColorImage;

/**
 * Created by Evegen on 18.11.2016.
 */
public class Car {
    String owner = "NoName";
    ColorImage carImage = new ColorImage("src\\main\\resources\\CarIntro\\Car5.png");
    ColorImage wImage = new ColorImage(800, 600);
    int odometer = 0;

    public Car() {
        Canvas canvas = new Canvas();
        canvas.add(this.wImage);
        canvas.add(this.carImage, 200, 200);
    }

    public Car(String nameOfOwner) {
        this.owner = nameOfOwner;
        this.carImage = new ColorImage();
        Canvas canvas = new Canvas();
        canvas.add(this.wImage);
        canvas.add(this.carImage, 200, 200);
    }

    public void move(int dist) {
        double radian = Math.toRadians((double)this.carImage.getRotation());
        double distX = (double)dist * Math.cos(radian);
        double distY = (double)dist * Math.sin(radian);
        this.odometer += dist;
        this.carImage.setX(this.carImage.getX() + (int)distX);
        this.carImage.setY(this.carImage.getY() + (int)distY);
    }

    public void moveCar(int dist) {
        int unit = 10;
        int steps = Math.abs(dist / unit);
        if(dist < 0) {
            unit = -unit;
        }

        for(int i = 0; i < steps; ++i) {
            this.move(unit);
            pause(20);
        }

    }

    public void turnCar(int rotateAngle) {
        double rAngleRadian = Math.toRadians(1.0D);
        double radius = (double)this.carImage.getWidth() * 2.0D;

        while(rotateAngle > 0) {
            this.carImage.setRotation((int)((double)this.carImage.getRotation() + 1.0D) % 360);
            double moveDist = Math.abs(2.0D * radius * Math.sin(rAngleRadian / 2.0D));
            this.move((int)moveDist);
            --rotateAngle;
            pause(10);
        }

    }

    public static void pause(int sleepTime) {
        try {
            Thread.sleep((long)sleepTime);
        } catch (InterruptedException var2) {
            System.err.println("Error in running rotation animation!");
            System.exit(-1);
        }

    }
}
