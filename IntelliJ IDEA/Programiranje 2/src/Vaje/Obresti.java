/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaje;

/**
 *
 * @author Mitja
 */

// Prvi program: izpis obresti 
public class Obresti {

  // Program izpise obresti na glavnico G.
  // Obrestna mera: p, stevilo let: n
  public static void main(String [] args) {
    // izpis besedila na zaslon
    System.out.println("Obresti!");
    
    // deklaracija spremenljivke tipa int (cela stevila)
    int G;
    // inicializacija spremenljivke
    G = 10000;
    
    // spr. lahko deklariramo in inicializiramo hkrati
    int n = 10;

    // deklaracija in inicializacija spr. tipa double (realna stevila)        
    double p = 3.5;

    // izracun rezultata    
    double rezultat = Math.pow(1+p/100,n) * G;
    
    // izpis rezultata z vsemi decimalkami
    System.out.println(rezultat);
    
    // izpis rezultata na dve decimalni mesti
    System.out.printf("%.2f \n", rezultat);
  }

}
