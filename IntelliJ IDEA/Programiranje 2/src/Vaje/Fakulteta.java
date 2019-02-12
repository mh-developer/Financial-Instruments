/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaje;

import java.lang.*;
/**
 *
 * @author Mitja
 */
public class Fakulteta {
    
    public static void main(String[] args) {
        tabela1();
        System.out.println();
        tabela2();
    }
    
    public static long fakultetaL(int n){
        long rezultat = 1;
        for (int i = 2; i <= n; i++){
            rezultat *= i;
        }
        return rezultat;
    }
    
    public static long stirlingL(int n){
        long rezultat = Math.round(Math.sqrt(2*Math.PI*n) * Math.pow(n/Math.E, n));
        return rezultat;
    }
    
    static double fakultetaD(int n){
        double rezultat = 1;
        for (int i = 2; i <= n; i++)
        {
            rezultat *= i;
        }
        return rezultat;
    }
    
    static double stirlingD(int n){
        double rezultat = (Math.sqrt(2*Math.PI*n) * Math.pow(n/Math.E, n));
        return rezultat;
    }
    
    static double napaka1(int n){
        double rezultat = (double)(100.0*(fakultetaL(n) - stirlingL(n)))/(double)fakultetaL(n);
        return rezultat;
    }
    
    static double napaka2(int n){
        double rezultat = (double)(100.0*(fakultetaD(n)-stirlingD(n)))/(double)fakultetaD(n);
        return rezultat;
    }
    
    public static void tabela1(){
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for(int i =1;i<=20;i++){
            System.out.printf("%3d%21d%21d%16.7f\n", i, fakultetaL(i), stirlingL(i), napaka1(i));
        }
    }

    public static void tabela2(){
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for(int i =1;i<=100;i++){
            System.out.printf("%3d%20.9e%20.9e%18.7f\n", i, fakultetaD(i), stirlingD(i), napaka2(i));
        }
    }
}
