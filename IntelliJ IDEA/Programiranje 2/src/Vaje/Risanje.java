package Vaje;


import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Prikaz uporabe razreda StdDraw. Pogoji za delovanje:
 * 
 * 1) datoteko stdlib.jar (ki se nahaja na eUčilnici - podstran Literatura)
 *    prenesite v folder na vašem računalniku
 * 2) V Netbeans projektu izberite Libraries / Add JAR/Folder in izberite 
 *    datoteko stdlib.jar
 * 3) Razred, ki uporablja StdDraw, so mora OBVEZNO nahajati v privzetem
 *    paketu (<default packages>).
 * 
 * @author tomaz
 */
public class Risanje {

  //Izris različno velikih krogov
  static void izris1() {
    StdDraw.setScale(-100, 100);

    StdDraw.clear(Color.BLACK);

    StdDraw.setPenColor(Color.yellow);
    for (int i = 0; i < 10; i++) {
      StdDraw.circle(0, 0, i * 10);
    }
  }

  // Kvadratna spirala
  static void izris2() {
    StdDraw.setScale(-100, 100);

    int[][] smeri = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    int trSmer = 0;
    int dolzina = 1;

    double pX = 0;
    double pY = 0;

    for (int i = 0; i < 1000; i++) {
      double nX = pX + dolzina * smeri[trSmer][0];
      double nY = pY + dolzina * smeri[trSmer][1];

      StdDraw.line(pX, pY, nX, nY);
      pX = nX;
      pY = nY;

      trSmer = (trSmer + 1) % 4;
      dolzina = dolzina + 1;
    }
  }

  // Risanje grafov funkcij
  static void izris3() {
    final int W = 200;
    final int H = 200;
    
    StdDraw.setXscale(0, W - 1);
    StdDraw.setYscale(0, H - 1);
    StdDraw.setPenRadius(0.01);

    // definicijsko območje
    double x1 = -2 * Math.PI;
    double x2 = 2 * Math.PI;
    double y1 = -1;
    double y2 = 1;

    double pX = -1;
    double pY = -1;

    for (int i = 0; i < W; i++) {
      double x = i * (x2 - x1) / (W - 1) + x1;

      // funkcija, ki jo rišemo
      double y = Math.sin(5 * x) / x;

      int j = (int) ((H - 1) * (y - y1) / (y2 - y1));
      if (j >= 0 && j < H) {
        if (pX != -1) {
          StdDraw.line(pX, pY, i, j);
        }
        pX = i;
        pY = j;

      }
    }
  }

  // Kazalec (za prikaz v "radarju" in v uri
  static void kazalec(int dolzina, int kot, double debelina) {
    double x = dolzina * Math.sin(2 * Math.PI * kot / 360);
    double y = dolzina * Math.cos(2 * Math.PI * kot / 360);
    StdDraw.setPenRadius(debelina);
    StdDraw.line(0, 0, x, y);
  }

  // Izris radarja
  static void izris4() {
    StdDraw.setScale(-100, 100);

    int dolzina = 70;

    int kot = 0;
    for (;;) {
      StdDraw.clear(Color.BLACK);
      StdDraw.setPenColor(Color.green);

      StdDraw.circle(0, 0, dolzina);
      StdDraw.circle(0, 0, dolzina / 4);
      StdDraw.circle(0, 0, dolzina / 2);
      StdDraw.circle(0, 0, 3 * dolzina / 4);

      kazalec(dolzina, kot, 0.01);

      kot = kot + 10;
      StdDraw.show(100);
    }
  }

  // Digitalna in analogna ura
  // Izziv: popravite uro tako, da bo bolj natančno kazala čas (sedaj je
  // urni kazalec vedno na celi številki (recimo, bodisi na 1 ali na 2),
  // čeprav bi moral biti nekje vmes). Popraviti se da vse tri kazalce!
  static void ura() {
    StdDraw.setScale(-100, 100);
    
    StdDraw.setPenColor(new Color(100, 200, 250));

    for (;;) {
      StdDraw.clear();
      for (int i = 1; i <= 12; i++) {
        String u = Integer.toString(i);
        double kot = 2 * Math.PI * 30 * i / 360;
        double x = 90 * Math.sin(kot);
        double y = 90 * Math.cos(kot);

        StdDraw.text(x, y, u);
      }
      
      for (int i = 0; i < 60; i++) {
        double kot = 2 * Math.PI * 6 * i / 360;
        double x1 = 80 * Math.sin(kot);
        double y1 = 80 * Math.cos(kot);

        double x2 = 75 * Math.sin(kot);
        double y2 = 75 * Math.cos(kot);
        
        StdDraw.line(x1, y1, x2, y2);
      }

      SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
      String ura = sdf.format(new Date());
      
      String [] deli = ura.split(":");
      int hh = Integer.parseInt(deli[0]);
      int mm = Integer.parseInt(deli[1]);
      int ss = Integer.parseInt(deli[2]);
      
      kazalec(80, 6*ss, 0.001);
      kazalec(60, 6*mm, 0.005);
      kazalec(40, 30*hh, 0.005);

      StdDraw.text(-90, 100, ura);
      
      StdDraw.show(1000);
    }
  }

  public static void main(String[] args) {
    // izris4();
    ura();
  }

}