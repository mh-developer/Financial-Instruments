package Domače_naloge;

import java.util.*;
import java.io.*;

public class DN13 {
    public static void main(String[] args) {
        if (args[0].equals("1")) {
            Slika s = Slika.preberiSliko(args[1]);
            Prikaz p = new Prikaz(s);
            p.prikazi();
        } else {
            System.out.println("V delu");
        }
    }
}

class Tocka {
    private int r;
    private int g;
    private int b;
    private int x;
    private int y;
    private double light;

    public Tocka(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Tocka(int s) {
        this.r = s;
        this.g = s;
        this.b = s;
    }

    public int[] getBarve() {
        return new int[]{this.r, this.g, this.b};
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getLight() {
        return this.light;
    }

    public void setLight(double light) {
        this.light = light;
    }
}

class Slika {
    private String size;
    private String ime;
    private String tip;
    private ArrayList<Tocka> piksli;

    public Slika(String size, String ime, String tip, ArrayList<Tocka> piksli) {
        this.size = size;
        this.ime = ime;
        this.tip = tip;
        this.piksli = piksli;
    }


    public String getIme() {
        return ime;
    }

    public int getVisina() {
        return Integer.parseInt(size.split("x")[1]);
    }

    public int getSirina() {
        return Integer.parseInt(size.split("x")[0]);
    }

    public Tocka getTocka(int x, int y) {
        for (Tocka t : this.piksli)
            if (t.getX() == x && t.getY() == y)
                return t;
        return null;
    }

    static Slika preberiSliko(String imeDatoteke) {
        String size = "";
        String tipSlike = "";
        ArrayList<Tocka> seznamTock = new ArrayList<>();
        try {
            int x = 0;
            int y = 0;
            Scanner sc = new Scanner(new File(imeDatoteke));
            String oznaka = sc.next();
            if (oznaka.charAt(3) == 'C')
                tipSlike = "barvna";
            else
                tipSlike = "sivinska";

            size = sc.next();
            int sirina = Integer.parseInt(size.split("x")[0]);
            int visina = Integer.parseInt(size.split("x")[1]);
            y = visina - 1;
            if (tipSlike.equals("sivinska")) {
                while (sc.hasNext()) {
                    int sivina = sc.nextInt();
                    Tocka t = new Tocka(sivina);
                    t.setX(x);
                    t.setY(y);
                    seznamTock.add(t);
                    if (x == sirina - 1) {
                        x = 0;
                        y--;
                    } else {
                        x++;
                    }
                }
            } else {
                while (sc.hasNext()) {
                    String[] rgb = sc.next().split("[;]");
                    int r = Integer.parseInt(rgb[0]);
                    int g = Integer.parseInt(rgb[1]);
                    int b = Integer.parseInt(rgb[2]);
                    Tocka t = new Tocka(r, g, b);
                    t.setX(x);
                    t.setY(y);
                    seznamTock.add(t);
                    if (x == sirina - 1) {
                        x = 0;
                        y--;
                    } else {
                        x++;
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Napaka:" + e.toString());
        }
        Slika s = new Slika(size, imeDatoteke, tipSlike, seznamTock);
        return s;
    }

    static Slika preberiSlikoBinarno(String imeDatoteke) {
        String size = "";
        String tipSlike = "";
        ArrayList<Tocka> seznamTock = new ArrayList<>();
        try {
            int x = 0;
            int y = 0;
            FileInputStream fis = new FileInputStream(new File(imeDatoteke));
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            String oznaka = "";
            for (int i = 0; i < 4; i++) {
                int c = dis.read();
                oznaka += (char) c; //
            }
            if (oznaka.charAt(3) == 'C') {
                tipSlike = "barvna";
            } else {
                tipSlike = "sivinska";
            }
            int sirina = dis.readInt();
            int visina = dis.readInt();
            size = sirina + "x" + visina;
            y = visina - 1;
            int c;
            if (tipSlike.equals("sivinska")) {
                while ((c = dis.read()) != -1) {
                    int sivina = c;
                    Tocka t = new Tocka(sivina);
                    t.setX(x);
                    t.setY(y);
                    seznamTock.add(t);
                    if (x == sirina - 1) {
                        x = 0;
                        y--;
                    } else {
                        x++;
                    }
                }
            } else {
                while ((c = dis.read()) != -1) {
                    int r = c;
                    int g = dis.read();
                    int b = dis.read();
                    Tocka t = new Tocka(r, g, b);
                    t.setX(x);
                    t.setY(y);
                    seznamTock.add(t);
                    if (x == sirina - 1) {
                        x = 0;
                        y--;
                    } else {
                        x++;
                    }
                }
            }
            dis.close();
        } catch (Exception e) {
            System.out.println("Napaka: " + e.toString());
        }
        Slika s = new Slika(size, imeDatoteke, tipSlike, seznamTock);
        return s;
    }

    static Slika preberi(String imeDatoteke) {
        Slika s;
        if (imeDatoteke.contains("p2t"))
            s = preberiSliko(imeDatoteke);
        else
            s = preberiSlikoBinarno(imeDatoteke);
        return s;
    }
}
