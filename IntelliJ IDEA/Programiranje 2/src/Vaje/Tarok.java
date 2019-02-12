/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaje;

import java.util.Random;


/**
 *
 * @author Mitja
 */
public class Tarok {
    static char pik = '\u2660'; // ♠
    static char kriz = '\u2663'; // ♣
    static char srce = '\u2665'; // ♥
    static char karo = '\u2666'; // ♦

    static char barve[] = {srce, karo, kriz, pik};
    static String prazneRdece[] = {"1", "2", "3", "4"};
    static String prazneCrne[] = {"7", "8", "9", "10"};

    static String figure[] = {"Fant", "Kaval", "Dama", "Kralj"};

    static String taroki[] = {
             "I", "II", "III", "IIII", "V", "VI", "VII",
             "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
             "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
             "XXI", "SKIS" 
    };
    
    public static void main(String[] args){
        /*
        String karte[] = ustvariKarte();
        premesajKarte(karte, 200);
        System.out.println(preprostoStetje(karte));
        izpisi(karte, 8);
        */
        String karte[] = ustvariKarte();
        premesajKarte(karte, 200);

        System.out.println("Prvi kup kart:");
        int kupcek1= natancnoStetje(karte, true, 0, 25);

        System.out.println("Drugi kup kart:");
        int kupcek2= natancnoStetje(karte, true, 25, 54);

        System.out.println("Natancno stetje 1. kupa kart: " + kupcek1);
        System.out.println("Natancno stetje 2. kupa kart: " + kupcek2);
    }
    
    static String[] ustvariKarte(){
        String[] karte = new String[54];
        int idx = 0;
        
        for(int i = 0;i<barve.length;i++){
            for(int j=0;j<prazneRdece.length;j++){
                if(i<2) 
                    karte[idx++]=barve[i]+prazneRdece[j];
                else 
                    karte[idx++]=barve[i]+prazneCrne[j];
            }
            for(int j=0;j<figure.length;j++){
                karte[idx++]=barve[i]+figure[j];
            }
            System.out.println();
        }
        for(int j = 0; j<taroki.length;j++){
            karte[idx++] = taroki[j];
        }
        
        return karte;
    }
    
    static void izpisi(String karte[], int vVrstici){
        for(int i = 0; i < karte.length; i++){
            if(karte[i] == null)
                break;
            System.out.print(karte[i] + " ");
            if(i % vVrstici == vVrstici-1){
                System.out.println();
            }
        }
        System.out.println();
    }
    
    
    static void premesajKarte(String karte[], int koliko){
        
        Random r = new Random();
        int k1;
        int k2;
        String tmp;
        
        for(int i = 0; i < koliko; i++){
            k1 = r.nextInt(karte.length);
            k2 = r.nextInt(karte.length);
            tmp = karte[k1];
            
            karte[k1] = karte[k2];
            karte[k2] = tmp;
        }
        
    }
    
    
    static int vrednostKarta(String k){
            if(k.equals("I") || k.equals("XXI") || k.equals("SKIS") || k.contains("Kralj")){
                return 5;
            }
            else if(k.contains("Dama")){
                return 4;
            }
            else if(k.contains("Kaval")){
                return 3;
            }
            else if(k.contains("Fant")){
                return 2;
            }
            else{
                return 1;
            }
    }
    
    
    static int preprostoStetje(String karte[]){
        int vsota = 0;
        
        for(int i = 0; i < karte.length; i++){
            if(karte[i] == null)
                break;
            vsota += vrednostKarta(karte[i]);
        }
        
        return vsota;
    }
    
    
    static int natancnoStetje(String karte[], boolean izpis, int z, int k){
        String[] kupcek = new String[k-z];
        int id = 0;
        for(int i = z; i < k; i++){
            kupcek[id++] = karte[i];
        }
        
        int v = preprostoStetje(kupcek);
        int vVrstici = 0;
        
        if(izpis){
            for(int i = 0; i < kupcek.length; i++){
                System.out.print(kupcek[i] + " ");
                vVrstici = vrednostKarta(kupcek[i]);
                if(i % 3 == 2){
                    System.out.print(vVrstici);
                    v -= 2;
                    vVrstici = 0;
                    System.out.println();
                }
            }
            if(kupcek.length % 3 != 0){
                System.out.print(vVrstici);
                v -= 1;
            }
            System.out.println();
        }
        
        return v;
    }
}
