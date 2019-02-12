
import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mh7860
 */
public class Naloga12 {

    public static void main(String[] args) {
        
        Integer[] stevila = preberiDatoteko(args[0]);
        
        Integer[] brezPod = brezPodvojenih(stevila);
        
        for (int i = 0; i < brezPod.length; i++) {
            System.out.printf("%d ",brezPod[i]);
        }
    }

    public static Integer[] brezPodvojenih(Integer[] stevil) {
        Integer[] brezPod = new Integer[stevil.length];
        int index = 0;

        for (int i = 0; i < stevil.length; i++) {
            for (int j = i+1; j < stevil.length; j++) {
                if (stevil[i] == stevil[j]) {
                    break;
                }

                if (j == stevil.length - 1) {
                    brezPod[index++] = stevil[i];
                }
            }
        }
        
        Integer[] brezPodKon = new Integer[index];
        
        for (int i = 0; i < index; i++) {
            brezPodKon[i] = brezPod[i];
        }

        return brezPodKon;
    }

    public static Integer[] preberiDatoteko(String imeDatoteke) {
        Integer[] stevila;

        try {
            Scanner s = new Scanner(new File(imeDatoteke));
            Integer[] t = new Integer[s.nextInt()];

            int stevec = 0;

            while (s.hasNextInt()) {
                t[stevec++] = s.nextInt();
            }

            stevila = t;
            
            s.close();
            return stevila;
        } catch (Exception e) {
            System.out.println(e);
        }

        return new Integer[]{};
    }
}
