/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domače_naloge;

/**
 *
 * @author Mitja
 */
public class DN02 {
    public static void main(String args[]) {
        if (args.length != 2) {
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    pravokotnik(i, j);
                    System.out.println();
                }
            }
        } else {
            pravokotnik(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
    }

    static void pravokotnik(int a, int b) {
        System.out.printf("a = %-2d, b = %-2d %3s", a, b, " ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.printf(j == 0 && i != 0 ? "%18s" : "", " ");
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
