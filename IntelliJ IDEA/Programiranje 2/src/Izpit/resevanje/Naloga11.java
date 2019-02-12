
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
public class Naloga11 {
    public static void main(String[] args) {
        ArrayList<String[]> igralke = preberiDatoteko(args[0]);
        ArrayList<String[]> igralci = preberiDatoteko(args[1]);
        
        ArrayList<String> s = new ArrayList<>();
        
        for(String[] i: igralke){
            //System.out.printf("%s \n", i[4]);
            
            for(String[] j: igralci){
                if(i[4].equals(j[4])){
                    s.add(String.format("Film: %s, Leto: %s, Igralka: %s, Igralec: %s\n", i[4], j[1], i[3], j[3]));
                }
            }
        }
        
        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        
        for(String izpis: s){
            System.out.print(izpis);
        }
        
        
    }
    
    public static ArrayList preberiDatoteko(String imeDatoteke){
        ArrayList<String[]> t = new ArrayList<>();
        
        try{
            Scanner s = new Scanner(new File(imeDatoteke));
            
            while(s.hasNextLine()){
                t.add(s.nextLine().split(", "));
            }
            
            
            s.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
        return t;
    }
}
