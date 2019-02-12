/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package Domače_naloge;

import java.io.*;
import java.util.*;

/**
 *
 * @author Mitja
 */
public class DN05 {
    public static void main(String[] args) throws Exception {
        switch(args[0]){
            case "1": sprotneNaloge(args[1]); break;
            case "2": izpisi(rotiraj(duplikati(preberi(args[1])), Integer.parseInt(args[2]))); break;
            case "3": tabela2DStevil(args[1]); break;
        }
    }
    
    // 1. naloga: Točke za vaje (6 točk)
    public static void sprotneNaloge(String datoteka) throws Exception {
        String[] najvecTock = new String[10];
        Scanner podatki = new Scanner(new File(datoteka));
        int trenutniMax = 0;
        int index = 0;
        
        while(podatki.hasNextLine()){
            String[] vVrstici = podatki.nextLine().split(":");
            int stTock = Integer.parseInt(vVrstici[1]);
            if(stTock >= trenutniMax){
                if(stTock > trenutniMax){
                    index = 0;
                    najvecTock = new String[10];
                }
                najvecTock[index++] = vVrstici[0];
                trenutniMax = stTock;
            }
        }
        podatki.close();
        
        System.out.printf("Max %d so dosegli:\n", trenutniMax);
        for (int i = 0; i < najvecTock.length; i++) {
            if(najvecTock[i] == null) break;
            System.out.println(najvecTock[i]);
        }
    }
    
    // 2. naloga: Tabele števil (7 točk)
    public static Integer[] preberi(String datoteka) throws Exception {
        Scanner podatki = new Scanner(new File(datoteka));
        Integer[] vsaStevila = new Integer[podatki.nextInt()];
        int stevec = 0;
        
        while(podatki.hasNextInt() ){
           vsaStevila[stevec++] = podatki.nextInt();
        }
        podatki.close();
        
        return vsaStevila;
    }
    
    public static int[] duplikati(Integer[] tabelaStevil) {
        String[] unikati = new String[tabelaStevil.length];
        int stevec = 0;
        
        for (int i = 0; i < tabelaStevil.length; i++) {
            for (int j = 0; j < unikati.length; j++) {
                if(unikati[j] != null && unikati[j].equals(tabelaStevil[i].toString())) break;
                if(unikati.length - j == 1) unikati[stevec++] = tabelaStevil[i].toString();
            }
        }
        
        int[] unikatiInt = new int[stevec];
        for (int i = 0; i < stevec; i++) unikatiInt[i] = Integer.parseInt(unikati[i]);
        
        return unikatiInt;
    }
    
    public static int[] rotiraj(int[] tabelaStevil, int k) {
        int tmp = 0;
        
        for (int i = 0; i < k; i++) {
            tmp = tabelaStevil[0];
            for (int j = 0; j < tabelaStevil.length-1; j++) tabelaStevil[j] = tabelaStevil[j+1];
            tabelaStevil[tabelaStevil.length-1] = tmp;
        }
        
        return tabelaStevil;
    }
    
    public static void izpisi(int[] tabelaStevil) {
        for (int i = 0; i < tabelaStevil.length; i++) System.out.printf("%d ", tabelaStevil[i]);
    }
    
    // 3. naloga: Še več tabel števil (7 točk)
    public static void tabela2DStevil(String datoteka) throws Exception{
        Scanner podatki = new Scanner(new File(datoteka));
        int vrstice = podatki.nextInt();
        int stolpci = podatki.nextInt();
        int[][] tabelaStevil = new int[vrstice][stolpci];
        
        for (int i = 0; i < vrstice; i++) {
            for (int j = 0; j < stolpci; j++) tabelaStevil[i][j] = podatki.nextInt();
        }
        podatki.close();
        
        for (int i = 0; i < stolpci; i++) {
            int[] sortiranje = new int[vrstice];
            for (int k = 0; k < sortiranje.length; k++) sortiranje[k] = tabelaStevil[k][i];
            Arrays.sort(sortiranje);
            for (int j = 0; j < vrstice; j++) tabelaStevil[j][i] = sortiranje[j];
        }
        
        for (int i = 0; i < vrstice; i++) {
            int vsota = 0;
            for (int j = 0; j < stolpci; j++) vsota += tabelaStevil[i][j];
            System.out.printf("%d ", vsota);
        }
    }
}
