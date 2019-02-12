package Vaje;

/**
 *
 * @author Mitja
 */

import java.awt.Font;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Kaca {

    private static Random random;

    /* IGRALNA POVRŠINA */
    private static final int HEIGHT = 20;
    private static final int WIDTH = 32;

    /* KAČA */
    private static final int SQUARE_WIDTH = 30; // širina kvadratka, ki bo sestavni del kače
    private static int[][] kaca; // seznam x in y koordinat kače
    private static int xGlava;
    private static int yGlava;
    private static int dolzina;

    /* HRANA */
    private static int xHrana;
    private static int yHrana;

    /* PARAMETRI IGRE */
    private static boolean playing = true;
    private static int delay = 8; // čas med posameznima frameoma

    /* SMERI GIBANJA KAČE */
    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private static int smer = RIGHT; // trenutna smer gibanja kače

    private static int tocke = 0;

    /* KODE SMERNIH TIPK */
    private static final int LEFT_BUTTON = 37;
    private static final int UP_BUTTON = 38;
    private static final int RIGHT_BUTTON = 39;
    private static final int DOWN_BUTTON = 40;

    public static void main(String[] args) {
        // ustvari igro
        initGame();

        int i = 0; // števec framov
        while (playing) {
            spremeniSmer();

            if (++i % 10 == 0) {
                // kačo izrišemo vsak deseti frame zaradi lažjega nadzora nad kačo
                premakni();
                show();
            }

            // med vsakim frameom počakamo določeno število milisekund
            StdDraw.pause(delay);
        }
    }

    private static void initGame() {
        StdDraw.setCanvasSize(WIDTH * SQUARE_WIDTH, HEIGHT * SQUARE_WIDTH);
        StdDraw.setXscale(0, WIDTH * SQUARE_WIDTH);
        StdDraw.setYscale(0, HEIGHT * SQUARE_WIDTH);

        xGlava = WIDTH / 2;
        yGlava = HEIGHT / 2;
        dolzina = 3;

        kaca = new int[HEIGHT * WIDTH][2];
        for (int i = 0; i < kaca.length; i++) {
            kaca[i] = new int[2];
        }

        for (int i = 0; i < dolzina; i++) {
            kaca[i][0] = xGlava - i;
            kaca[i][1] = yGlava;
        }
    }

    private static void spremeniSmer() {
        if(StdDraw.isKeyPressed(LEFT_BUTTON)){
            smer = LEFT;
        }
        else if(StdDraw.isKeyPressed(UP_BUTTON)){
            smer = UP;
        }
        else if(StdDraw.isKeyPressed(RIGHT_BUTTON)){
            smer = RIGHT;
        }
        else if(StdDraw.isKeyPressed(DOWN_BUTTON)){
            smer = DOWN;
        }
    }

    private static void premakni() {
        switch (smer) {
            case RIGHT:
                xGlava++;
                break;
            case DOWN:
                yGlava--;
                break;
            case LEFT:
                xGlava--;
                break;
            case UP:
                yGlava++;
                break;
        }
        
        for (int i = dolzina; i > 0; i--) {
            if(!vKaci(kaca[0][0], kaca[0][1])){
                playing = false;
            }
            
            
            kaca[i][0] = kaca[i - 1][0];
            kaca[i][1] = kaca[i - 1][1];
        }

        kaca[0][0] = xGlava;
        kaca[0][1] = yGlava;
    }
    
    static boolean vKaci(int x, int y) {
        if (x < 0 || x > WIDTH) {
            return false;
        }
        else if (y < 0 || y > HEIGHT) {
            return false;
        }
        
        return true;
    }

    private static void show() {
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);


        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.GRAY);

        for (int i = 0; i < dolzina; i++) {
            if(!playing){
                Font font = new Font("Arial", Font.BOLD, 60);
                StdDraw.setFont(font);
                StdDraw.text(WIDTH / 2, HEIGHT / 2, "GAME OVER");
            }
            
            double a = kaca[i][0];
            double b = kaca[i][1];
            StdDraw.filledSquare(a, b, 0.5);
        }
        StdDraw.show(100);
    }

    private static void nastaviHrano() {
        random = new Random();
        
        
    }

}
