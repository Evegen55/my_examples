package Algorithms;

import java.time.Year;

public class ArrayInNutshell {

    public static class MyClass {
        public int i = 0;
        public int k = 1;
    }

    public static void main(String[] args) {
        Year year = Year.now();

        Year[] years = new Year[1];
        years[0] = year;

        System.out.println(year + "\t" + years[0]);

        year = Year.of(2017);
        System.out.println(year + "\t" + years[0]);

        year = null;
        System.out.println(year + "\t" + years[0]);

        MyClass myClass = new MyClass();
        MyClass[] myClasses = new MyClass[1];
        myClasses[0] = myClass;

        System.out.println(myClasses[0].i + "\t" + myClasses[0].k);

    }
}
