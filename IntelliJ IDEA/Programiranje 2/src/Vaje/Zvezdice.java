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
public class Zvezdice{
	public static void main(String[] args){
		pravokotnik(3, 3, 7);
		trikotnik(5, 5);
		okvir(0, 4, 15);
		
		
		trikotnik(5, 10);
		okvir(7, 10, 15);
		
		dvaPravokotnika(5, 15, 3, 6);
		
		trikotnik(8, 8);
		pravokotnik(8, 10, 15);
		dvaPravokotnika(10, 5, 7, 3);
                
                
                X(4);
	}
	
	static void pravokotnik(int odmik, int visina, int sirina){
		for(int i = 1; i <= visina; i++){
			if(odmik == 0){
				System.out.printf("%s", " ");
			}
			else{
				System.out.printf("%"+ odmik +"s", " ");
			}
			for(int j= 1; j <= sirina; j++){
				System.out.print("*");
				
			}
			System.out.println();
		}
	}
	
	static void trikotnik(int odmik, int visina){
		int s = 1;
		for(int i = 1; i <= visina; i++){
			for(int j = i-odmik; j < visina; j++){
				System.out.print(" ");
			}
			for(int k = 1; k < (2*i); k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void okvir(int odmik, int visina, int sirina){
		for(int i = 1; i <= visina; i++){
			if(odmik == 0){
				System.out.printf("%s", " ");
			}
			else{
				System.out.printf("%"+ odmik +"s", " ");
			}
			for(int j = 1; j <= sirina; j++){
				if(i == 1 || i == visina){
					System.out.print("*");
				}
				else{
					if(j == 1 || j == sirina){
						System.out.print("*");
					}
					else{
						System.out.printf("%s", " ");
					}
				}
			}
			System.out.println();
		}
	}
	
	static void dvaPravokotnika(int odmik, int razmik, int visina, int sirina){
		for(int i = 1; i <= visina; i++){
			if(odmik == 0){
				System.out.printf("%s", " ");
			}
			else{
				System.out.printf("%"+ odmik +"s", " ");
			}
			for(int j = 1; j <= sirina; j++){
				System.out.print("*");
			}
			System.out.printf(razmik > 0 ? "%"+ razmik +"s" : "%s", " ");
			for(int k = 1; k <= sirina; k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void X(int n){
		for (int i = 0; i < n - 1; i++) {
                    dvaPravokotnika(5 * i, 10 * n - 10 * i - 15, 3, 5);
                }
                pravokotnik((n - 1) * 5, 3, 5);
                for (int i = n - 2; i >= 0; i--) {
                    dvaPravokotnika(5 * i, 10 * n - 10 * i - 15, 3, 5);
                }
	}
}
