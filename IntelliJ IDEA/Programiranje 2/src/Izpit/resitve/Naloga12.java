package Izpit.resitve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Alenka
 */
public class Naloga12 {

  // v tabeli izbriše podvojene elemente (tj. vse ponovitve števila) ter vrne novo tabelo brez podvojitev
  public static int[] brezPodvojenih(int[] tabela) {
    int n = tabela.length; // število elementov v tabeli
    for (int i = 0; i < n; i++) { // sprehodimo se preko vseh števil
      int stevilo = tabela[i];
      // za vsako število poiščemo ponovitve števila v preostanku tabele
      for (int j = i + 1; j < n; j++) {
        if (tabela[j] == stevilo) {
          // če ponovitev najdemo, prepišemo vse elemente za eno mesto višje
          for (int k = j + 1; k < n; k++) {
            tabela[k - 1] = tabela[k];
          }
          // število elementov v tabeli se zmanjša za ena
          n = n - 1;
          // še enkrat ponovimo za isti j
          j--;
        }
      }
    }
    // sestavimo novo tabelo ustrezne velikosti in jo vrnemo
    int[] nova = new int[n];
    for (int i = 0; i < n; i++) {
      nova[i] = tabela[i];
    }
    return nova;
  }

  public static void main(String[] args) throws FileNotFoundException {
    if (args.length < 1) {
      System.exit(1);
    }
    Scanner sc = new Scanner(new File(args[0]));
    int n = sc.nextInt(); // koliko stevil je v datoteki
    int[] tabela = new int[n];
    int i = 0;
    while (sc.hasNextInt()) {
      tabela[i] = sc.nextInt();
      i++;
    }
    sc.close();
    tabela = brezPodvojenih(tabela);
    for (int el : tabela) {
      System.out.printf("%d ", el);
    }
    System.out.println();
  }

}
