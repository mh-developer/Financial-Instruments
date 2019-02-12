package Vaje;

import java.io.File;
import java.util.Scanner;

public class TELEFONSKI_IMENIK {
    public static void main(String[] args) throws Exception {
        Imenik i = new Imenik("viri/imenik.txt");
        i.isciOseboPoImenu("John").izpis();
        i.isciOsebePoPosti("1000");
    }


}


class Imenik{

    private Oseba[] imenikOseb = new Oseba[100];

    Imenik(String vir) throws Exception{
        this.preberiOsebe(vir);
    }

    private Oseba[] preberiOsebe(String vir) throws Exception {
        Scanner s = new Scanner(new File(vir));

        int id = 0;
        while (s.hasNextLine()){
            String[] podatkiOsebe = s.nextLine().split(", ");
            Oseba novaOseba = new Oseba(podatkiOsebe[0], podatkiOsebe[1], podatkiOsebe[2], podatkiOsebe[4], podatkiOsebe[3], podatkiOsebe[5]);
            imenikOseb[id++] = novaOseba;
        }

        return imenikOseb;
    }

    Oseba isciOseboPoImenu(String ime){
        for (int i = 0; i < imenikOseb.length; i++){
            if (imenikOseb[i] == null){
                break;
            }
            if(ime.toLowerCase().equals(imenikOseb[i].ime.toLowerCase())){
                return imenikOseb[i];
            }
        }
        return null;
    }

    void isciOsebePoPosti(String posta) {
        int stevec = 0;

        for (int i = 0; i < imenikOseb.length; i++) {
            if (imenikOseb[i] == null){
                break;
            }
            if(posta.toLowerCase().equals(imenikOseb[i].posta.toLowerCase())){
                stevec++;
            }
        }
        System.out.print(stevec);
    }
}

class Oseba{
    String ime;
    String priimek;
    String naslov;
    String mesto;
    String posta;
    String telefon;

    Oseba(String ime, String priimek, String naslov, String mesto, String posta, String telefon) {
        this.ime = ime;
        this.priimek = priimek;
        this.naslov = naslov;
        this.mesto = mesto;
        this.posta = posta;
        this.telefon = telefon;
    }

    void izpis(){
        System.out.printf("%s, %s, %s, %s, %s, %s\n", this.ime, this.priimek, this.naslov, this.mesto, this.posta, this.telefon);
    }

}