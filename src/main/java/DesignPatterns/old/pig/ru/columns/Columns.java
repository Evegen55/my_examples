package DesignPatterns.old.pig.ru.columns;

import DesignPatterns.old.pig.ru.columns.model.Figure;
import DesignPatterns.old.pig.ru.columns.model.Model;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;


public class Columns extends Applet implements Runnable {
    private static final int SL = 25;
    private static final int TIME_SHIFT = 250;
    private static final int FIG_TO_DROP = 33;
    private static final int MIN_TIME_SHIFT = 200;
    private static final int LEFT_BORDER = 2;
    private static final int TOP_BORDER = 2;

    private static final Random Random = new Random();

    Color MyStyles[] = {Color.black, Color.cyan, Color.blue, Color.red, Color.green,
            Color.yellow, Color.pink, Color.magenta, Color.black};

    int Level;
    int i;
    int j;
    int ii;
    int k;
    int ch;
    long Score;
    long DScore;
    long tc;
    Font fCourier;
    boolean NoChanges = true, KeyPressed = false;
    Graphics graphics;

    Thread thread = null;

    Model model = new Model();


    void checkNeighbours(int a, int b, int c, int d, int i, int j) {
        if ((getFieldNew()[j][i] == getFieldNew()[a][b]) && (getFieldNew()[j][i] == getFieldNew()[c][d])) {
            getFieldOld()[a][b] = 0;
            drawBox(a, b, 8);
            getFieldOld()[j][i] = 0;
            drawBox(j, i, 8);
            getFieldOld()[c][d] = 0;
            drawBox(c, d, 8);
            NoChanges = false;
            Score += (Level + 1) * 10;
            k++;
        }
        ;
    }

    private int[][] getFieldOld() {
        return model.getFieldOld();
    }

    private int[][] getFieldNew() {
        return model.getFieldNew();
    }

    void delay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    void drawBox(int x, int y, int c) {
        if (c == 0) {
            graphics.setColor(Color.black);
            graphics.fillRect(LEFT_BORDER + x * SL - SL, TOP_BORDER + y * SL - SL, SL, SL);
            graphics.drawRect(LEFT_BORDER + x * SL - SL, TOP_BORDER + y * SL - SL, SL, SL);
        } else if (c == 8) {
            graphics.setColor(Color.white);
            graphics.drawRect(LEFT_BORDER + x * SL - SL + 1, TOP_BORDER + y * SL - SL + 1, SL - 2, SL - 2);
            graphics.drawRect(LEFT_BORDER + x * SL - SL + 2, TOP_BORDER + y * SL - SL + 2, SL - 4, SL - 4);
            graphics.setColor(Color.black);
            graphics.fillRect(LEFT_BORDER + x * SL - SL + 3, TOP_BORDER + y * SL - SL + 3, SL - 6, SL - 6);
        } else {
            graphics.setColor(MyStyles[c]);
            graphics.fillRect(LEFT_BORDER + x * SL - SL, TOP_BORDER + y * SL - SL, SL, SL);
            graphics.setColor(Color.black);
            graphics.drawRect(LEFT_BORDER + x * SL - SL, TOP_BORDER + y * SL - SL, SL, SL);
        }
        //		g.setColor (Color.black);
    }

    void drawField() {
        for (int i = 1; i <= Model.Depth; i++) {
            for (int j = 1; j <= Model.Width; j++) {
                drawBox(j, i, getFieldNew()[j][i]);
            }
        }
    }

    void drawFigure(Figure f) {
        drawBox(f.x, f.y, f.c[1]);
        drawBox(f.x, f.y + 1, f.c[2]);
        drawBox(f.x, f.y + 2, f.c[3]);
    }

    void dropFigure(Figure f) {
        int zz;
        if (f.y < Model.Depth - 2) {
            zz = Model.Depth;
            while (getFieldNew()[f.x][zz] > 0) zz--;
            DScore = (((Level + 1) * (Model.Depth * 2 - f.y - zz) * 2) % 5) * 5;
            f.y = zz - 2;
        }
    }

    boolean isFieldFull() {
        for (int i = 1; i <= Model.Width; i++) {
            if (getFieldNew()[i][3] > 0)
                return true;
        }
        return false;
    }

    void hideFigure(Figure f) {
        drawBox(f.x, f.y, 0);
        drawBox(f.x, f.y + 1, 0);
        drawBox(f.x, f.y + 2, 0);
    }

    @Override
    public void init() {
        setFieldNew(new int[Model.Width + 2][Model.Depth + 2]);
        setFieldOld(new int[Model.Width + 2][Model.Depth + 2]);
        graphics = getGraphics();
    }

    private void setFieldOld(int[][] ints) {
        model.setFieldOld(ints);
    }

    private void setFieldNew(int[][] ints) {
        model.setFieldNew(ints);
    }

    @Override
    public boolean keyDown(Event e, int k) {
        KeyPressed = true;
        ch = e.key;
        return true;
    }

    @Override
    public boolean lostFocus(Event e, Object w) {
        KeyPressed = true;
        ch = 'P';
        return true;
    }

    @Override
    public void paint(Graphics g) {
        //		showHelp(g);

        g.setColor(Color.black);

        showLevel(g);
        showScore(g);
        drawField();
        drawFigure(getFig());
        requestFocus();
    }

    public void run() {
        setupGame();

        do {
            tc = System.currentTimeMillis();
            setFig(new Figure(Random));
            drawFigure(getFig());
            while ((getFig().y < Model.Depth - 2) && (getFieldNew()[getFig().x][getFig().y + 3] == 0)) {
                if ((int) (System.currentTimeMillis() - tc) > (Model.MaxLevel - Level) * TIME_SHIFT + MIN_TIME_SHIFT) {
                    tc = System.currentTimeMillis();
                    hideFigure(getFig());
                    getFig().y++;
                    drawFigure(getFig());
                }
                DScore = 0;
                do {
                    delay(50);
                    if (KeyPressed) {
                        KeyPressed = false;
                        switch (ch) {
                            case Event.LEFT:
                                if ((getFig().x > 1) && (getFieldNew()[getFig().x - 1][getFig().y + 2] == 0)) {
                                    hideFigure(getFig());
                                    getFig().x--;
                                    drawFigure(getFig());
                                }
                                break;
                            case Event.RIGHT:
                                if ((getFig().x < Model.Width) && (getFieldNew()[getFig().x + 1][getFig().y + 2] == 0)) {
                                    hideFigure(getFig());
                                    getFig().x++;
                                    drawFigure(getFig());
                                }
                                break;
                            case Event.UP:
                                i = getFig().c[1];
                                getFig().c[1] = getFig().c[2];
                                getFig().c[2] = getFig().c[3];
                                getFig().c[3] = i;
                                drawFigure(getFig());
                                break;
                            case Event.DOWN:
                                i = getFig().c[1];
                                getFig().c[1] = getFig().c[3];
                                getFig().c[3] = getFig().c[2];
                                getFig().c[2] = i;
                                drawFigure(getFig());
                                break;
                            case ' ':
                                hideFigure(getFig());
                                dropFigure(getFig());
                                drawFigure(getFig());
                                tc = 0;
                                break;
                            case 'P':
                            case 'p':
                                while (!KeyPressed) {
                                    hideFigure(getFig());
                                    delay(500);
                                    drawFigure(getFig());
                                    delay(500);
                                }
                                tc = System.currentTimeMillis();
                                break;
                            case '-':
                                if (Level > 0) Level--;
                                k = 0;
                                showLevel(graphics);
                                break;
                            case '+':
                                if (Level < Model.MaxLevel) Level++;
                                k = 0;
                                showLevel(graphics);
                                break;
                        }
                    }
                }
                while ((int) (System.currentTimeMillis() - tc) <= (Model.MaxLevel - Level) * TIME_SHIFT + MIN_TIME_SHIFT);
            }
            ;
            model.pasteFigure(getFig(), this);
            do {
                NoChanges = true;
                testField();
                if (!NoChanges) {
                    delay(500);
                    model.packField(this);
                    drawField();
                    Score += DScore;
                    showScore(graphics);
                    if (k >= FIG_TO_DROP) {
                        k = 0;
                        if (Level < Model.MaxLevel) Level++;
                        showLevel(graphics);
                    }
                }
            } while (!NoChanges);
        } while (!isFieldFull());
    }

    private void setupGame() {
        for (i = 0; i < Model.Width + 1; i++) {
            for (j = 0; j < Model.Depth + 1; j++) {
                getFieldNew()[i][j] = 0;
                getFieldOld()[i][j] = 0;
            }
        }
        Level = 0;
        Score = 0;
        j = 0;
        k = 0;
        graphics.setColor(Color.black);
        requestFocus();
    }

    private void setFig(Figure figure) {
        model.setFig(figure);
    }

    private Figure getFig() {
        return model.getFig();
    }

    void showHelp(Graphics g) {
        g.setColor(Color.black);

        g.drawString(" Keys available:", 200 - LEFT_BORDER, 102);
        g.drawString("Roll Box Up:     ", 200 - LEFT_BORDER, 118);
        g.drawString("Roll Box Down:   ", 200 - LEFT_BORDER, 128);
        g.drawString("Figure Left:     ", 200 - LEFT_BORDER, 138);
        g.drawString("Figure Right:    ", 200 - LEFT_BORDER, 148);
        g.drawString("Level High/Low: +/-", 200 - LEFT_BORDER, 158);
        g.drawString("Drop Figure:   space", 200 - LEFT_BORDER, 168);
        g.drawString("Pause:           P", 200 - LEFT_BORDER, 180);
        g.drawString("Quit:     Esc or Q", 200 - LEFT_BORDER, 190);
    }

    void showLevel(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LEFT_BORDER + 100, 390, 100, 20);
        g.drawString("Level: " + Level, LEFT_BORDER + 100, 400);
    }

    void showScore(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LEFT_BORDER, 390, 100, 20);
        g.drawString("Score: " + Score, LEFT_BORDER, 400);
    }

    @Override
    public void start() {
        graphics.setColor(Color.black);

        //		setBackground (new Color(180,180,180));

        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    void testField() {
        for (int i = 1; i <= Model.Depth; i++) {
            for (int j = 1; j <= Model.Width; j++) {
                getFieldOld()[j][i] = getFieldNew()[j][i];
            }
        }
        for (int i = 1; i <= Model.Depth; i++) {
            for (int j = 1; j <= Model.Width; j++) {
                if (getFieldNew()[j][i] > 0) {
                    checkNeighbours(j, i - 1, j, i + 1, i, j);
                    checkNeighbours(j - 1, i, j + 1, i, i, j);
                    checkNeighbours(j - 1, i - 1, j + 1, i + 1, i, j);
                    checkNeighbours(j + 1, i - 1, j - 1, i + 1, i, j);
                }
            }
        }
    }
}
