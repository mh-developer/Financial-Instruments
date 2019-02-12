package Vaje;

import java.util.*;
import java.io.*;

/**
 *
 * @author Mitja
 */
public class Sifriranje {
    
    public static void main(String[] args) throws Exception{
        odkodiraj("viri/pesem.txt", "viri/kodirano.txt");
    }
    
    static void odkodiraj(String kodirnaKnjiga, String koda) throws Exception{
        Scanner s = new Scanner(new File(kodirnaKnjiga));
        Scanner k = new Scanner(new File(koda));
        String kodirnaK = "";
        String hash = "";
        
        
        String dekodiranje = "";
        
        while(s.hasNext()){
            kodirnaK += " " + s.next();
        }
        
        String[] kodirnaKArray = kodirnaK.split(" ");
        
        
        int k1;
        int k2;
        String beseda;
        
        while(k.hasNextInt()){
            /*
            if(hash.equals("")){
                hash += k.nextInt();
            }
            else{
                hash += " " + k.nextInt();
            }
            */
            
            k1 = k.nextInt();
            if(k1 != 0){
                beseda = kodirnaKArray[k1];
                dekodiranje += beseda.charAt(k.nextInt()-1);
            }
        }
        
        String[] hashArray = hash.split(" ");
        
        /*
        
        for (int i = 0; i < hashArray.length; i++) {
            k1 = Integer.parseInt(hashArray[i]);
            if(k1 != 0){
                beseda = kodirnaKArray[k1];
                dekodiranje += beseda.charAt(Integer.parseInt(hashArray[k1+1])-1);
            }
        }
        */
        /*
        for (int i = 0; i < hashArray.length; i++) {
            System.out.println(hashArray[i]);
        }
        */
        
        System.out.print(dekodiranje);
    }
    
}
