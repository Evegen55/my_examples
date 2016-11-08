package DesignPatterns.old.pig.ru.columns.model;

import DesignPatterns.old.pig.ru.columns.Columns;

import java.awt.*;

/**
 * @author Evgenii_Lartcev (created on 11/7/2016).
 */
public class Model implements GameEventListener {
    public static final int Depth = 15;
    public static final int Width = 7;
    public static final int MaxLevel = 7;
    private Figure Fig;
    private int[][] fieldNew;
    private int[][] fieldOld;
    private int Level;

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Model() throws HeadlessException {
        super();
    }

    public Figure getFig() {
        return Fig;
    }

    public void setFig(Figure fig) {
        Fig = fig;
    }

    public void setFieldNew(int[][] fieldNew) {
        this.fieldNew = fieldNew;
    }

    public void setFieldOld(int[][] fieldOld) {
        this.fieldOld = fieldOld;
    }

    public int[][] getFieldNew() {
        return fieldNew;
    }

    public int[][] getFieldOld() {
        return fieldOld;
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void rotateUp() {

    }

    @Override
    public void drop() {

    }

    public void packField(Columns columns) {
        int n;
        for (int i = 1; i <= Width; i++) {
            n = Depth;
            for (int j = Depth; j > 0; j--) {
                if (fieldOld[i][j] > 0) {
                    fieldNew[i][n] = fieldOld[i][j];
                    n--;
                }
            }
            for (int j = n; j > 0; j--) fieldNew[i][j] = 0;
        }
    }

    public void pasteFigure(Figure f, Columns columns) {
        fieldNew[f.x][f.y] = f.c[1];
        fieldNew[f.x][f.y + 1] = f.c[2];
        fieldNew[f.x][f.y + 2] = f.c[3];
    }
}
