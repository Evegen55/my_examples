package DesignPatterns.old.pig.ru.columns.model;

import java.applet.Applet;
import java.awt.*;

/**
 * @author Evgenii_Lartcev (created on 11/7/2016).
 */
public class Model {
    public static final int Depth=15;
    public static final int Width=7;
    public static final int MaxLevel=7;
    private Figure Fig;
    private int[][] fieldNew;
    private int[][] fieldOld;

    public Model() throws HeadlessException {
        super();
    }

    public Figure getFig() {
        return Fig;
    }

    public void setFig(Figure fig) {
        Fig = fig;
    }

    public int[][] getFieldNew() {
        return fieldNew;
    }

    public void setFieldNew(int[][] fieldNew) {
        this.fieldNew = fieldNew;
    }

    public int[][] getFieldOld() {
        return fieldOld;
    }

    public void setFieldOld(int[][] fieldOld) {
        this.fieldOld = fieldOld;
    }
}
