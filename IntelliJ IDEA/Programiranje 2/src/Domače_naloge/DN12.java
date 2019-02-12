package Domače_naloge;

import java.io.*;

public class DN12 {
    private static int globina = 0;

    public static void main(String[] args) {
        System.out.println(args[0]);
        tree(args[0]);

    }

    public static void tree(String mapa) {
        File folder = new File(mapa);
        String[] seznamDatotek = folder.list();
        //System.out.println(folder.getAbsolutePath());
        for (String imeDatoteke : seznamDatotek) {
            if (new File(mapa + "/" + imeDatoteke).isDirectory()) {
                System.out.print("  ");
                for (int i = 0; i < globina; i++) {
                    System.out.print("|  ");
                }
                System.out.println("|___" + imeDatoteke);
                globina++;
                tree(mapa + "/" + imeDatoteke);
                globina--;

            } else {
                System.out.print("  ");
                for (int i = 0; i < globina; i++) {
                    System.out.print("|  ");
                }
                System.out.println("|___" + imeDatoteke);
            }
        }
    }
}
