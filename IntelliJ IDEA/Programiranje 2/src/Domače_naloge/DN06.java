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
public class DN06 {

    public static void main(String[] args) throws Exception {
        dekodiranje(args[0]);
    }

    public static void dekodiranje(String datoteka) throws Exception {
        Scanner s = new Scanner(new File(datoteka));
        String podatki;
        while (s.hasNext()) {
            podatki = s.next();
            for (int j = 0; j < podatki.length(); j += 8) {
                System.out.print((char) Integer.parseInt(podatki.substring(j, j + 8), 2));
            }
        }
        s.close();
        System.out.println();
    }
}
