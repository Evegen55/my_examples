package DesignPatterns.old.pig.ru.columns.model;

import DesignPatterns.old.pig.ru.columns.Columns;

import java.util.Random;


public class Figure {
    public int x = Model.Width / 2 + 1;
    public int y = 1;
    public int c[] = new int[4];
    final Random r;

    public Figure(Random r) {
        this.r = r;
        //c[0] = 0;
        c[1] = Math.abs(r.nextInt()) % 7 + 1;
        c[2] = Math.abs(r.nextInt()) % 7 + 1;
        c[3] = Math.abs(r.nextInt()) % 7 + 1;
    }
}
