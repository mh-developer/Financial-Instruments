/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Domače_naloge;*/

/**
 *
 * @author Mitja
 */
public class DN03 {
    public static void main(String[] args){
        int operator = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);
        String s = args[1];
        
        if(operator == 1 && args.length == 3){
            System.out.print(a + " + " + b + " = " + (a+b));
        }
        else if(operator == 2 && args.length == 3){
            System.out.print(a + " - " + b + " = " + (a-b));
        }
        else if(operator == 3 && args.length == 3){
            System.out.print(a + " * " + b + " = " + (a*b));
        }
        else if(operator == 4 && args.length == 3 && b != 0){
            System.out.print(a + " / " + b + " = " + (a/b));
        }
        else if(operator == 5){
            System.out.print("Minimum stevil ");
            for(int i = 1; i < args.length; i++){
                System.out.print(args[i] + " ");
                if(i == 1){
                    a = Double.parseDouble(args[i]);
                }
                else{
                    if(Double.parseDouble(args[i]) < a){
                        s = args[i];
                        a = Double.parseDouble(args[i]);
                    }
                }
            }
            System.out.print("je " + s);
        }
        else{
            System.out.println("Napaka, niste vnesli pravilnega operatorja operatorja.");
        }   
    }
    
    
}
