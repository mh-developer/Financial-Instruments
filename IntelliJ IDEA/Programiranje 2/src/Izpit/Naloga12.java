package Izpit;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Naloga12 {
    public static void main(String[] args) {
        Integer[] stevila = preberiDatoteko(args[0]);

        Integer[] brezPonovitev = brezPodvojenih(stevila);

        for (int i = 0; i < brezPonovitev.length; i++) {
            System.out.printf("%d ", brezPonovitev[i]);
        }
    }

    public static Integer[] brezPodvojenih(Integer[] tabela) {
        ArrayList<Integer> ar = new ArrayList<>();

        for (int i = 0; i < tabela.length; i++) {
            for (Integer j : ar) {
                if(tabela[i] == j){

                }
            }
        }

        Integer[] brezPon = new Integer[/*index*/100];

        for (int i = 0; i < brezPon.length; i++) {
            //brezPon[i] = a[i];
        }

        return brezPon;
    }

    public static Integer[] preberiDatoteko(String imeDatoteke) {
        ArrayList<Integer> ar = new ArrayList<>();
        int stevec = 0;

        try {
            Scanner s = new Scanner(new File(imeDatoteke));

            Integer[] tab = new Integer[s.nextInt()];

            while (s.hasNextInt()) {
                ar.add(s.nextInt());
                stevec++;
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        Integer[] tabela = new Integer[stevec];

        stevec = 0;

        for (Integer i : ar) {
            tabela[stevec++] = i;
        }

        return tabela;
    }

}
