///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package vaje;
//
///**
// *
// * @author Marcel
// */
////import edu.princeton.cs.introcs.StdDraw;
//import edu.princeton.cs.introcs.StdDraw;
//import java.awt.Color;
//import java.util.Random;
//import java.awt.event.KeyEvent;
//
//public class VAJE07 {
//
//    private static Random random;
//
//    /* IGRALNA POVRŠINA */
//    private static final int HEIGHT = 20;
//    private static final int WIDTH = 32;
//
//    /* KAČA */
//    private static final int SQUARE_WIDTH = 30; // širina kvadratka, ki bo sestavni del kače
//    private static int[][] kaca; // seznam x in y koordinat kače
//    private static int xGlava;
//    private static int yGlava;
//    private static int dolzina;
//
//    /* HRANA */
//    private static int xHrana;
//    private static int yHrana;
//
//    /* PARAMETRI IGRE */
//    private static boolean playing = true;
//    private static int delay = 8; // čas med posameznima frameoma
//
//    /* SMERI GIBANJA KAČE */
//    private static final int UP = 0;
//    private static final int RIGHT = 1;
//    private static final int DOWN = 2;
//    private static final int LEFT = 3; 
//
//    private static int smer = RIGHT; // trenutna smer gibanja kače
//
//    private static int tocke = 0;
//
//    /* KODE SMERNIH TIPK */
//    private static final int LEFT_BUTTON = 37;
//    private static final int UP_BUTTON = 38;
//    private static final int RIGHT_BUTTON = 39;
//    private static final int DOWN_BUTTON = 40;
//
//    public static void main(String[] args) {
//        // ustvari igro
//        initGame();
//
//        int i = 0; // števec framov
//        while (playing) {
//            spremeniSmer();
//            if (++i % 10 == 0) {
//                // kačo izrišemo vsak deseti frame zaradi lažjega nadzora nad kačo
//                premakni();
//                show();
//            }
//
//            // med vsakim frameom počakamo določeno število milisekund
//            StdDraw.pause(delay);
//        }
//        StdDraw.text(WIDTH / 2, HEIGHT / 2, "GAME OVER");
//    }
//
//    private static void initGame() {
//        StdDraw.setCanvasSize(WIDTH*30, HEIGHT*30);
//        xGlava = WIDTH / 2;
//        yGlava = HEIGHT / 2;
//        dolzina = 3;
//        kaca = new int[WIDTH * HEIGHT][2];
//        kaca[0][0] = xGlava;
//        kaca[0][1] = yGlava;
//        for (int i = 1; i <= dolzina - 1; i++) {
//            kaca[i][0] = xGlava - i;
//            kaca[i][1] = yGlava;
//        }
//    }
//
//    private static void spremeniSmer() {
//        if(StdDraw.isKeyPressed(KeyEvent.VK_UP)){
//            smer = UP;
//        }
//        else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
//            smer = DOWN;
//        }
//        else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
//            smer = LEFT;
//        }
//        else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
//            smer = RIGHT;
//        }
//    }
//
//    private static void premakni() {
//        int zac1 = 0;
//        int zac2 = 0;
//        zac1 = kaca[0][0];
//        zac2 = kaca[0][1];
//        int zac11 = 0;
//        int zac22 = 0;
//        for (int i = 0; i < dolzina; i++){
//            if(vKaci(kaca[0][0],kaca[0][1]) == false){
//                playing = false;
//            }
//            if(i == 0 && smer == 1){
//                kaca[0][0] += 1;
//            }
//            else if(i == 0 && smer == 0){
//                kaca[0][1] += 1;
//            }
//            else if(i == 0 && smer == 2){
//                kaca[0][1] -= 1;
//            }
//            else if(i == 0 && smer == 3){
//                kaca[0][0] -= 1;
//            }
//            else{
//                zac11 = kaca[i][0];
//                zac22 = kaca[i][1];
//                kaca[i][0] = zac1;
//                kaca[i][1] = zac2;
//                zac1 = zac11;
//                zac2 = zac22;
//            }
//        }
//    }
//
//    static boolean vKaci(int x, int y){
//        if(x<0 || x>WIDTH){
//            return false;
//        }
//        else if(y<0 || y>HEIGHT){
//            return false;
//        }
//        return true;
//    }
//    
//    private static void show() {
//        StdDraw.setXscale(0, WIDTH);
//        StdDraw.setYscale(0, HEIGHT);
//        //StdDraw.setScale(0.1, 0.2);
//        StdDraw.clear();
//        StdDraw.setPenColor(StdDraw.GRAY);
//
//        for (int i = 0; i < dolzina; i++) {
//            double a = kaca[i][0];
//            double b = kaca[i][1];
//            StdDraw.filledSquare(a, b, 0.5);
//        }
//    }
//
//    private static void nastaviHrano() {
//        
//    }
//
//}
