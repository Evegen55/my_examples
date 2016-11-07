package DesignPatterns.old.pig.ru.columns;

import DesignPatterns.old.pig.ru.columns.model.Figure;
import DesignPatterns.old.pig.ru.columns.model.Model;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;


public class Columns extends Applet implements Runnable {
    public static final int SL = 25;
    public static final int TimeShift = 250;
    public static final int FigToDrop = 33;
    public static final int MinTimeShift = 200;
    public static final int LeftBorder = 2;
    public static final int TopBorder = 2;

    private static final Random Random = new Random();


    Color MyStyles[] = {Color.black, Color.cyan, Color.blue, Color.red, Color.green,
            Color.yellow, Color.pink, Color.magenta, Color.black};

    int Level, i, j, ii, k, ch;
    long Score, DScore, tc;
    Font fCourier;
    boolean NoChanges = true, KeyPressed = false;
    Graphics _gr;

    Thread thr = null;

    Model model = new Model();


    void CheckNeighbours(int a, int b, int c, int d, int i, int j) {
        if ((getFieldNew()[j][i] == getFieldNew()[a][b]) && (getFieldNew()[j][i] == getFieldNew()[c][d])) {
            getFieldOld()[a][b] = 0;
            DrawBox(a, b, 8);
            getFieldOld()[j][i] = 0;
            DrawBox(j, i, 8);
            getFieldOld()[c][d] = 0;
            DrawBox(c, d, 8);
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

    void Delay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
        }
        ;
    }

    void DrawBox(int x, int y, int c) {
        if (c == 0) {
            _gr.setColor(Color.black);
            _gr.fillRect(LeftBorder + x * SL - SL, TopBorder + y * SL - SL, SL, SL);
            _gr.drawRect(LeftBorder + x * SL - SL, TopBorder + y * SL - SL, SL, SL);
        } else if (c == 8) {
            _gr.setColor(Color.white);
            _gr.drawRect(LeftBorder + x * SL - SL + 1, TopBorder + y * SL - SL + 1, SL - 2, SL - 2);
            _gr.drawRect(LeftBorder + x * SL - SL + 2, TopBorder + y * SL - SL + 2, SL - 4, SL - 4);
            _gr.setColor(Color.black);
            _gr.fillRect(LeftBorder + x * SL - SL + 3, TopBorder + y * SL - SL + 3, SL - 6, SL - 6);
        } else {
            _gr.setColor(MyStyles[c]);
            _gr.fillRect(LeftBorder + x * SL - SL, TopBorder + y * SL - SL, SL, SL);
            _gr.setColor(Color.black);
            _gr.drawRect(LeftBorder + x * SL - SL, TopBorder + y * SL - SL, SL, SL);
        }
        //		g.setColor (Color.black);
    }

    void DrawField(Graphics g) {
        int i, j;
        for (i = 1; i <= Model.Depth; i++) {
            for (j = 1; j <= Model.Width; j++) {
                DrawBox(j, i, getFieldNew()[j][i]);
            }
        }
    }

    void DrawFigure(Figure f) {
        DrawBox(f.x, f.y, f.c[1]);
        DrawBox(f.x, f.y + 1, f.c[2]);
        DrawBox(f.x, f.y + 2, f.c[3]);
    }

    void DropFigure(Figure f) {
        int zz;
        if (f.y < Model.Depth - 2) {
            zz = Model.Depth;
            while (getFieldNew()[f.x][zz] > 0) zz--;
            DScore = (((Level + 1) * (Model.Depth * 2 - f.y - zz) * 2) % 5) * 5;
            f.y = zz - 2;
        }
    }

    boolean FullField() {
        int i;
        for (i = 1; i <= Model.Width; i++) {
            if (getFieldNew()[i][3] > 0)
                return true;
        }
        return false;
    }

    void HideFigure(Figure f) {
        DrawBox(f.x, f.y, 0);
        DrawBox(f.x, f.y + 1, 0);
        DrawBox(f.x, f.y + 2, 0);
    }

    public void init() {
        setFieldNew(new int[Model.Width + 2][Model.Depth + 2]);
        setFieldOld(new int[Model.Width + 2][Model.Depth + 2]);
        _gr = getGraphics();
    }

    private void setFieldOld(int[][] ints) {
        model.setFieldOld(ints);
    }

    private void setFieldNew(int[][] ints) {
        model.setFieldNew(ints);
    }

    public boolean keyDown(Event e, int k) {
        KeyPressed = true;
        ch = e.key;
        return true;
    }

    public boolean lostFocus(Event e, Object w) {
        KeyPressed = true;
        ch = 'P';
        return true;
    }

    void PackField() {
        int i, j, n;
        for (i = 1; i <= Model.Width; i++) {
            n = Model.Depth;
            for (j = Model.Depth; j > 0; j--) {
                if (getFieldOld()[i][j] > 0) {
                    getFieldNew()[i][n] = getFieldOld()[i][j];
                    n--;
                }
            }
            ;
            for (j = n; j > 0; j--) getFieldNew()[i][j] = 0;
        }
    }

    public void paint(Graphics g) {
        //		ShowHelp(g);

        g.setColor(Color.black);

        ShowLevel(g);
        ShowScore(g);
        DrawField(g);
        DrawFigure(getFig());
        requestFocus();
    }

    void PasteFigure(Figure f) {
        getFieldNew()[f.x][f.y] = f.c[1];
        getFieldNew()[f.x][f.y + 1] = f.c[2];
        getFieldNew()[f.x][f.y + 2] = f.c[3];
    }

    public void run() {
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
        _gr.setColor(Color.black);
        requestFocus();

        do {
            tc = System.currentTimeMillis();
            setFig(new Figure(Random));
            DrawFigure(getFig());
            while ((getFig().y < Model.Depth - 2) && (getFieldNew()[getFig().x][getFig().y + 3] == 0)) {
                if ((int) (System.currentTimeMillis() - tc) > (Model.MaxLevel - Level) * TimeShift + MinTimeShift) {
                    tc = System.currentTimeMillis();
                    HideFigure(getFig());
                    getFig().y++;
                    DrawFigure(getFig());
                }
                DScore = 0;
                do {
                    Delay(50);
                    if (KeyPressed) {
                        KeyPressed = false;
                        switch (ch) {
                            case Event.LEFT:
                                if ((getFig().x > 1) && (getFieldNew()[getFig().x - 1][getFig().y + 2] == 0)) {
                                    HideFigure(getFig());
                                    getFig().x--;
                                    DrawFigure(getFig());
                                }
                                break;
                            case Event.RIGHT:
                                if ((getFig().x < Model.Width) && (getFieldNew()[getFig().x + 1][getFig().y + 2] == 0)) {
                                    HideFigure(getFig());
                                    getFig().x++;
                                    DrawFigure(getFig());
                                }
                                break;
                            case Event.UP:
                                i = getFig().c[1];
                                getFig().c[1] = getFig().c[2];
                                getFig().c[2] = getFig().c[3];
                                getFig().c[3] = i;
                                DrawFigure(getFig());
                                break;
                            case Event.DOWN:
                                i = getFig().c[1];
                                getFig().c[1] = getFig().c[3];
                                getFig().c[3] = getFig().c[2];
                                getFig().c[2] = i;
                                DrawFigure(getFig());
                                break;
                            case ' ':
                                HideFigure(getFig());
                                DropFigure(getFig());
                                DrawFigure(getFig());
                                tc = 0;
                                break;
                            case 'P':
                            case 'p':
                                while (!KeyPressed) {
                                    HideFigure(getFig());
                                    Delay(500);
                                    DrawFigure(getFig());
                                    Delay(500);
                                }
                                tc = System.currentTimeMillis();
                                break;
                            case '-':
                                if (Level > 0) Level--;
                                k = 0;
                                ShowLevel(_gr);
                                break;
                            case '+':
                                if (Level < Model.MaxLevel) Level++;
                                k = 0;
                                ShowLevel(_gr);
                                break;
                        }
                    }
                }
                while ((int) (System.currentTimeMillis() - tc) <= (Model.MaxLevel - Level) * TimeShift + MinTimeShift);
            }
            ;
            PasteFigure(getFig());
            do {
                NoChanges = true;
                TestField();
                if (!NoChanges) {
                    Delay(500);
                    PackField();
                    DrawField(_gr);
                    Score += DScore;
                    ShowScore(_gr);
                    if (k >= FigToDrop) {
                        k = 0;
                        if (Level < Model.MaxLevel) Level++;
                        ShowLevel(_gr);
                    }
                }
            } while (!NoChanges);
        } while (!FullField());
    }

    private void setFig(Figure figure) {
        model.setFig(figure);
    }

    private Figure getFig() {
        return model.getFig();
    }

    void ShowHelp(Graphics g) {
        g.setColor(Color.black);

        g.drawString(" Keys available:", 200 - LeftBorder, 102);
        g.drawString("Roll Box Up:     ", 200 - LeftBorder, 118);
        g.drawString("Roll Box Down:   ", 200 - LeftBorder, 128);
        g.drawString("Figure Left:     ", 200 - LeftBorder, 138);
        g.drawString("Figure Right:    ", 200 - LeftBorder, 148);
        g.drawString("Level High/Low: +/-", 200 - LeftBorder, 158);
        g.drawString("Drop Figure:   space", 200 - LeftBorder, 168);
        g.drawString("Pause:           P", 200 - LeftBorder, 180);
        g.drawString("Quit:     Esc or Q", 200 - LeftBorder, 190);
    }

    void ShowLevel(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LeftBorder + 100, 390, 100, 20);
        g.drawString("Level: " + Level, LeftBorder + 100, 400);
    }

    void ShowScore(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LeftBorder, 390, 100, 20);
        g.drawString("Score: " + Score, LeftBorder, 400);
    }

    public void start() {
        _gr.setColor(Color.black);

        //		setBackground (new Color(180,180,180));

        if (thr == null) {
            thr = new Thread(this);
            thr.start();
        }
    }

    public void stop() {
        if (thr != null) {
            thr.stop();
            thr = null;
        }
    }

    void TestField() {
        int i, j;
        for (i = 1; i <= Model.Depth; i++) {
            for (j = 1; j <= Model.Width; j++) {
                getFieldOld()[j][i] = getFieldNew()[j][i];
            }
        }
        for (i = 1; i <= Model.Depth; i++) {
            for (j = 1; j <= Model.Width; j++) {
                if (getFieldNew()[j][i] > 0) {
                    CheckNeighbours(j, i - 1, j, i + 1, i, j);
                    CheckNeighbours(j - 1, i, j + 1, i, i, j);
                    CheckNeighbours(j - 1, i - 1, j + 1, i + 1, i, j);
                    CheckNeighbours(j + 1, i - 1, j - 1, i + 1, i, j);
                }
            }
        }
    }
}
