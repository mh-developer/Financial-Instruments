package Vaje;

import java.util.*;
import java.io.*;

/**
 *
 * @author Mitja
 */
public class Vislice {
    
    static final int MAX_NAPAK = 10;

  // Seznam fraz; dopolnite ga s poljubnimi frazami
    // (vec ko jih bo, bolj zabavna bo igra)
    static String[] fraze = {"SONCE SIJE", "TRAVA RASTE", "KOLESAR BRZI",
        "ZIDAR ZIDA", "METLA POMETA", "VELIKA NOGA", "RDECA VRTNICA",
        "SLEPA ULICA", "MODRINA NEBA", "SABLJA", "NETOPIR", "KOLOVRAT",
        "SMUCANJE", "BELE STRMINE", "OTROCI SE ZOGAJO", "BABICA LIKA",
        "PROGRAMER PROGRAMIRA", "SKAF IMA LUKNJO", "VISLICE SO ZABAVNE"};

    // fraza, ki jo uganjujemo
    static String fraza;

    // katere crke smo ze uganili
    static boolean uganil[];

    static int steviloNapak;

    static void novaIgra() {
        Random r = new Random();
        fraza = fraze[r.nextInt(fraze.length)];
        uganil = new boolean[fraza.length()];
        for (int i = 0; i < uganil.length; i++) {
            uganil[i] = (fraza.charAt(i) == ' ' ? true : false);
        }
        steviloNapak = 0;
    }

    static boolean jeUganil() {
        for (int i = 0; i < uganil.length; i++) {
            if(uganil[i] == false) return false;
        }
        return true;
    }

    static void izpisiUganko() {
        for (int i = 0; i < uganil.length; i++) {  
            System.out.print(uganil[i] ? fraza.charAt(i) : '.');
        }
        System.out.println();
    }

    static void postaviVprasanje() {
        System.out.printf("Naredite lahko še %d napak: ", MAX_NAPAK-steviloNapak);
        Scanner s = new Scanner(System.in);
        String vpisanZnak = s.nextLine().toUpperCase();
        boolean trenutnaCrka = false;
        for (int i = 0; i < uganil.length; i++) {
            if(vpisanZnak.length() > 1 && vpisanZnak.equals(fraza)){
                trenutnaCrka = true;
                for (int j = 0; j < uganil.length; j++) uganil[j] = true;
                break;
            }
            else if (fraza.charAt(i) == vpisanZnak.charAt(0)) {
                uganil[i] = true;
                trenutnaCrka = true;
            }
        }
        if (!trenutnaCrka) steviloNapak++;
    }

    public static void main(String args[]) {
        Crke.izpisi(Crke.getCrko(new int[] {0, 0, 0, 0, 0, 0, 0, 255}));
        novaIgra();
        while ((steviloNapak < MAX_NAPAK) && !jeUganil()) {
            izpisiUganko();
            postaviVprasanje();
        }
        if (jeUganil()) {
            System.out.println(fraza);
            System.out.println("Bravo!");
        } else {
            System.out.println("Konec igre! Pravilen odgovor je: " + fraza);
        }
    }
}
