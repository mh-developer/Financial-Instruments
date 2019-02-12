/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domače_naloge;

import java.util.Random;

/**
 *
 * @author Mitja
 */
public class Gesla {

  static String[] prva   = {"Miha", "Micka", "Tone", "Lojze", "Mojca", "Pepca", "Franci", "Francka"};
  static String[] druga  = {"vozi", "seka", "potrebuje", "gleda", "barva", "voha", "lomi", "popravlja"};
  static String[] tretja = {"kolo", "avto", "likalnik", "sonce", "vrtnico", "drevo", "lopato", "sekiro"};

  static String ustvariGeslo() {
    Random rnd = new Random();
    int rnd1 = rnd.nextInt(prva.length);
    int rnd2 = rnd.nextInt(druga.length);
    int rnd3 = rnd.nextInt(tretja.length);
    
    return prva[rnd1] + " " + druga[rnd2] + " " + tretja[rnd3];
  }

  public static void main(String[] args) {
    System.out.println(ustvariGeslo());

  }

}
