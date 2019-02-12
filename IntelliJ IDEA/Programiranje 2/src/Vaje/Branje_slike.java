package Vaje;

import java.io.*;


public class Branje_slike {
    public static void main(String[] args) {


        metaPodatki(args[0]);
    }

    public static void metaPodatki(String slika) {
        try {
            FileInputStream fis = new FileInputStream(new File(slika));
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            String pngFormat = "89504E470D0A1A0A";
            String podpis = String.format("%X", dis.readLong());
            int size = dis.readInt();
            String ihdr = String.format("%X", dis.readInt());
            int sirina = dis.readInt();
            int visina = dis.readInt();

            // System.out.printf("%X\n %X\n %s\n %d\n %d\n", podpis, size, ihdr, sirina, visina);

            if (pngFormat.equals(podpis) && ihdr.equals("49484452")) {
                System.out.printf("Datoteka %s je slika tipa PNG velikosti %d x %d.", slika, sirina, visina);
            } else {
                System.out.printf("Datoteka %s je slika tipa ??? velikosti %d x %d.", slika, sirina, visina);
            }
            dis.close();

        } catch (Exception en){
            System.out.println(en);

        }
    }
}
/*
class NapakaSlike extends Exception {
    public napakaSlike() {
        super();
    }

    public napakaSlike(String napaka) {
        super(napaka);
    }
}
*/

class Slika {
    private String slika;
    private String podpis;
    private int size;
    private String ihdr;
    private int sirina;
    private int visina;

    public Slika(String slika) {
        this.slika = slika;
        this.metaPodatki(slika);
    }

    public void metaPodatki(String slika) {
        try {
            FileInputStream fis = new FileInputStream(new File(slika));
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            this.podpis = String.format("%X", dis.readLong());
            this.size = dis.readInt();
            this.ihdr = String.format("%X", dis.readInt());
            this.sirina = dis.readInt();
            this.visina = dis.readInt();

            dis.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void izpis() {
        if (this.podpis.equals("89504E470D0A1A0A") && this.ihdr.equals("49484452")) {
            System.out.printf("Datoteka %s je slika tipa PNG velikosti %d x %d.", this.slika, this.sirina, this.visina);
        } else {
            System.out.printf("Datoteka %s je slika tipa ??? velikosti %d x %d.", this.slika, this.sirina, this.visina);
        }
    }


}


class Folder {
    private static int globina = 0;

    public static void main(String[] args) {
        System.out.println(args[0]);
        tree(args[0]);

    }

    public static void tree(String mapa) {
        File folder = new File(mapa);
        String[] seznamDatotek = folder.list();
        //System.out.println(folder.getAbsolutePath());
        for (String imeDatoteke : seznamDatotek) {
            if (new File(mapa + "/" + imeDatoteke).isDirectory()) {
                System.out.print("  ");
                for (int i = 0; i < globina; i++) {
                    System.out.print("|  ");
                }
                System.out.println("|___" + imeDatoteke);
                globina++;
                tree(mapa + "/" + imeDatoteke);
                globina--;

            } else {
                System.out.print("  ");
                for (int i = 0; i < globina; i++) {
                    System.out.print("|  ");
                }
                System.out.println("|___" + imeDatoteke);
            }
        }
    }
}
