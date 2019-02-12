package Domače_naloge;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

/**
 *
 * @author Mitja
 */
public class DN07 {

    static void narisi(int x, int y, Color b, int v) {
        StdDraw.setScale(-1000, 1000);

        double velikostCveta = v * 3;

        StdDraw.setPenColor(0, 240, 0);
        StdDraw.setPenRadius(0.01);

        // Dolžina stebla
        StdDraw.line(x, y - v, x, y - v * 9);

        // Listi
        StdDraw.setPenColor(b);
        StdDraw.filledCircle(x + velikostCveta - (velikostCveta / 7), y, v * 2);
        StdDraw.filledCircle(x - velikostCveta + (velikostCveta / 7), y, v * 2);
        StdDraw.filledCircle(x, y + velikostCveta - (velikostCveta / 7), v * 2);
        StdDraw.filledCircle(x, y - velikostCveta + (velikostCveta / 7), v * 2);

        // Pestič in prašniki
        StdDraw.setPenColor(0, 240, 0);
        StdDraw.filledCircle(x, y, v);
    }

    public static void main(String[] args) {
        StdDraw.clear();
        Color[] barva = {StdDraw.BLACK, StdDraw.BLUE, StdDraw.CYAN, StdDraw.DARK_GRAY, StdDraw.GRAY, StdDraw.GREEN, StdDraw.LIGHT_GRAY, StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PINK, StdDraw.RED, StdDraw.WHITE, StdDraw.YELLOW};
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            narisi(r.nextInt(1500) - 750, r.nextInt(1500) - 750, barva[r.nextInt(barva.length - 1)], r.nextInt(100));
        }
    }
}
