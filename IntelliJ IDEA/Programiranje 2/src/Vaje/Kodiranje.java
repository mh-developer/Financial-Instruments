package Vaje;


import java.io.File;
import java.util.Scanner;

public class Kodiranje {

    public static void main(String[] args) throws Exception {
        CezarjevAlgoritem a = new CezarjevAlgoritem(2);

        System.out.println(a.enkripcija("abcd"));
        System.out.println(a.dekripcija("bcde"));

        XOR _xor = new XOR("abcdefghi");

        System.out.println(_xor.enkripcija("abcd"));
        System.out.println(_xor.dekripcija(_xor.enkripcija("abcdasdsdfas")));
    }


    static String preberiIzDatoteke(String imeDatoteke) throws Exception {
        Scanner s = new Scanner(new File(imeDatoteke));
        StringBuilder sb = new StringBuilder();

        while (s.hasNext()) {
            sb.append(s.next());
        }
        s.close();

        return sb.toString();
    }


    static void zapisiVDatoteko(String sporočilo, String imeDatoteke) throws Exception {

    }
}


interface Kodirnik {
    String enkripcija(String besedilo);

    String dekripcija(String besedilo);
}


class CezarjevAlgoritem implements Kodirnik {

    private int zamik;

    public CezarjevAlgoritem(int zamik) {
        this.zamik = zamik % 26;
    }

    public String enkripcija(String besedilo) {
        StringBuilder beseda = new StringBuilder();
        char[] crke = besedilo.toCharArray();

        for (int i = 0; i < crke.length; i++) {
            char c = crke[i];
            if (Character.isLowerCase(c)) {
                c += zamik;
                if (c > 'z') {
                    c -= 26;
                } else if (c < 'a') {
                    c += 26;
                }
            }
            if (Character.isUpperCase(c)) {
                c += zamik;
                if (c > 'Z') {
                    c -= 26;
                } else if (c < 'A') {
                    c += 26;
                }
            }
            beseda.append(c);
        }
        return beseda.toString();
    }

    public String dekripcija(String besedilo) {
        StringBuilder beseda = new StringBuilder();
        char[] crke = besedilo.toCharArray();

        for (int i = 0; i < crke.length; i++) {
            char c = crke[i];
            if (Character.isLowerCase(c)) {
                c -= zamik;
                if (c > 'z') {
                    c -= 26;
                } else if (c < 'a') {
                    c += 26;
                }
            }
            if (Character.isUpperCase(c)) {
                c -= zamik;
                if (c > 'Z') {
                    c -= 26;
                } else if (c < 'A') {
                    c += 26;
                }
            }
            beseda.append(c);
        }
        return beseda.toString();
    }
}

class XOR implements Kodirnik {

    private String kljuc;

    public XOR(String kljuc) {
        this.kljuc = kljuc;
    }

    public String enkripcija(String niz) {
        StringBuilder zakodiran_niz = new StringBuilder();

        for (int i = 0; i < niz.length(); i++) {
            zakodiran_niz.append((char) (niz.charAt(i) ^ kljuc.charAt(i % kljuc.length())));
        }
        return zakodiran_niz.toString();
    }

    public String dekripcija(String zakodirano) {
        return enkripcija(zakodirano);
    }

}