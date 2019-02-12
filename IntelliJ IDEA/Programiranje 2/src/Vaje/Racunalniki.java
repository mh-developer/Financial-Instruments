package Vaje;

import edu.princeton.cs.introcs.StdOut;

import java.io.File;
import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class Racunalniki {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("viri/komponente.txt"));

        Komponenta[] trgovina = new Komponenta[100];
        Pomnilnik[] trgovinaPom = new Pomnilnik[100];
        MaticnaPlosca[] trgovinaMP = new MaticnaPlosca[100];
        Procesor[] trgovinaProc = new Procesor[100];

        int id = 0;
        int id1 = 0;
        int id2 = 0;
        int id3 = 0;

        while (s.hasNextLine()) {
            String[] kom = s.nextLine().split(";");
            switch (kom[0]) {
                case "Pomnilnik":
                    Pomnilnik pom = new Pomnilnik(kom[1], Double.parseDouble(kom[2]), Integer.parseInt(kom[3]), Integer.parseInt(kom[4]), Integer.parseInt(kom[5]));
                    trgovina[id++] = pom;
                    trgovinaPom[id1++] = pom;
                    break;
                case "Maticna":
                    MaticnaPlosca mp = new MaticnaPlosca(kom[1], Double.parseDouble(kom[2]), kom[3], kom[4], Integer.parseInt(kom[5]));
                    trgovina[id++] = mp;
                    trgovinaMP[id2++] = mp;
                    break;
                case "Procesor":
                    Procesor p = new Procesor(kom[1], Double.parseDouble(kom[2]), kom[3], Integer.parseInt(kom[4]), Integer.parseInt(kom[5]));
                    trgovina[id++] = p;
                    trgovinaProc[id3++] = p;
                    break;
            }
        }

        s.close();


        for (int i = 0; i < trgovina.length; i++) {
            if (trgovina[i] == null)
                break;
            System.out.println(trgovina[i]);
            System.out.println();
        }


        for (int i = 0; i < trgovinaMP.length; i++) {
            if (trgovinaMP[i] == null)
                break;
            String t = trgovinaMP[i].getVrsta();
            if (t.equals("Maticna")) {
                for (int j = 0; j < trgovinaProc.length; j++) {
                    if (trgovinaProc[j] == null)
                        break;
                    String p = trgovinaProc[j].getVrsta();
                    if (p.equals("Procesor") && trgovinaMP[i].jeKompatibilna(trgovinaProc[j])) {
                        System.out.println("Procesor: " + trgovinaProc[j].getIme() + " in maticna plosca: " + trgovinaMP[i].getIme() +
                        " sta kompatibilna (podnozje " + trgovinaMP[i].getPodnozje() + ").");
                    }
                }
            }
        }
    }
}


class Komponenta {
    String ime;
    double cena;
    int popust;

    public Komponenta(String ime, double cena, int popust) {
        this.ime = ime;
        this.cena = cena;
        this.popust = popust;
    }

    public String toString() {

        return this.ime + ", cena s popustom: " + String.format("%.2f", cenaSPopustom()) + "€";
    }

    public double cenaSPopustom() {
        return this.cena * (100.0 - this.popust) / 100.0;
    }

    public String getIme() {
        return ime;
    }
}

class Pomnilnik extends Komponenta {
    int tip;
    int velikost;
    int hitrost;

    public Pomnilnik(String ime, double cena, int tip, int velikost, int hitrost) {
        super(ime, cena, 10);
        this.tip = tip;
        this.velikost = velikost;
        this.hitrost = hitrost;
    }

    public String toString() {
        return "Pomnilnik: " + super.toString() + "\n" + "Tip: " +
                (this.tip == 0 ? "SDRAM, " : this.tip == 1 ? "DDR, " : this.tip == 2 ? "DDR2, " : this.tip == 3 ? "DDR3, " : ", ") +
                "velikost: " + this.velikost + "GB, " + "hitrost: " + this.hitrost + "MHz";
    }

    public String getVrsta() {
        return "Pomnilnik";
    }
}

class MaticnaPlosca extends Komponenta {
    String format;
    String podnozje;
    int steviloPomnilniskihRez;

    public MaticnaPlosca(String ime, double cena, String format, String podnozje, int steviloPomnilniskihRez) {
        super(ime, cena, 15);
        this.format = format;
        this.podnozje = podnozje;
        this.steviloPomnilniskihRez = steviloPomnilniskihRez;
    }

    public String toString() {
        return "Maticna plosca: " + super.toString() + "\n" + "Format: " + this.format +
                "podnozje: " + this.podnozje + "GB, " + "stevilo pomn. rez: " + this.steviloPomnilniskihRez;
    }

    public boolean jeKompatibilna(Procesor p) {
        return p.podnozje.equals(this.podnozje);
    }

    public String getVrsta() {
        return "Maticna";
    }

    public String getPodnozje() {
        return podnozje;
    }
}

class Procesor extends Komponenta {
    String podnozje;
    int steviloJeder;
    int hitrostJedra;

    public Procesor(String ime, double cena, String podnozje, int steviloJeder, int hitrostJedra) {
        super(ime, cena, 5);
        this.podnozje = podnozje;
        this.steviloJeder = steviloJeder;
        this.hitrostJedra = hitrostJedra;
    }

    public String toString() {
        return "Procesor: " + super.toString() + "\n" + "Podnozje: " + this.podnozje +
                "st. jeder: " + this.steviloJeder + "GB, " + "hitrost jedra: " + this.hitrostJedra + "MHz";
    }

    public String getVrsta() {
        return "Procesor";
    }
}


