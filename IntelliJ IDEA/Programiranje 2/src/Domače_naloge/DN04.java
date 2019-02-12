/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Domače_naloge;

/**
 *
 * @author Mitja
 */
public class DN04 {
    static String[] prva   = {"Miha", "Micka", "Tone", "Lojze", "Mojca", "Pepca", "Franci", "Francka"};
    static String[] druga  = {"vozi", "seka", "potrebuje", "gleda", "barva", "voha", "lomi", "popravlja"};
    static String[] tretja = {"kolo", "avto", "likalnik", "sonce", "vrtnico", "drevo", "lopato", "sekiro"};
  
    public static void main(String[] args){
        String[] ar = args.clone();
        System.out.println(gesloObstaja(ar));
    }
    
    public static boolean gesloObstaja(String ar[]){
        boolean obstaja1 = false;
        boolean obstaja2 = false;
        boolean obstaja3 = false;
        //System.out.print(ar.length);
        if (ar.length == 3){
            for(int i = 0; i < prva.length; i++){
                if(prva[i].equals(ar[0])){
                    obstaja1 = true;
                    break;
                }
            }
            for(int i = 0; i < druga.length; i++){
                if(druga[i].equals(ar[1])){
                    obstaja2 = true;
                    break;
                }
            }
            for(int i = 0; i < tretja.length; i++){
                if(tretja[i].equals(ar[2])){
                    obstaja3 = true;
                    break;
                }
            }
        }
        if(obstaja1 == true && obstaja2 == true && obstaja3 == true){
            return true;
        }
        else{
            return false;
        }
    }
    
}
