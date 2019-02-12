package Izpit.resitve;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author aless
 */
class NajboljsiFilm {

  private String naslov = null;
  private String igralec = null;
  private String igralka = null;
  private int leto;

  public NajboljsiFilm(String naslov, int leto) {
    this.naslov = naslov;
    this.leto = leto;
  }

  public void setIgralka(String igralka) {
    this.igralka = igralka;
  }

  public void setIgralec(String igralec) {
    this.igralec = igralec;
  }

  public String toString() {
    return String.format("Film: %s, Leto: %d, Igralka: %s, Igralec: %s", naslov, leto, igralka, igralec);
  }

  public boolean hasBoth() {
    return (igralec != null && igralka != null);
  }
}

public class Naloga11 {

  static TreeMap<String, NajboljsiFilm> map;

  public static void poisciPare(String igralke, String igralci) {
    Scanner sc1 = null, sc2 = null;
    map = new TreeMap<>();
    try {
      sc1 = new Scanner(new File(igralke));
      sc1.nextLine();
      sc2 = new Scanner(new File(igralci));
      sc2.nextLine();
      while (sc1.hasNextLine()) {
        String items[] = sc1.nextLine().split(", ");
        map.put(items[4], new NajboljsiFilm(items[4], Integer.parseInt(items[1])));
        map.get(items[4]).setIgralka(items[3]);
      }
      while (sc2.hasNextLine()) {
        String items[] = sc2.nextLine().split(", ");
        if (map.containsKey(items[4])) {
          map.get(items[4]).setIgralec(items[3]);
        }
      }
    } catch (Exception e) {
      System.out.println("Napaka pri delu z datotekami: " + e.getMessage());
    } finally {
      try {
        if (sc1 != null) {
          sc1.close();
        }
        if (sc2 != null) {
          sc2.close();
        }
      } catch (Exception e) {
        System.out.println("Napaka pri zapiranju datotek: " + e.getMessage());
      }
    }
    List<String> kljuci = new ArrayList<>(map.keySet());
    for (String key : kljuci) {
      if (map.get(key).hasBoth()) {
        System.out.println(map.get(key));
      }
    }
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Premalo argumentov");
      return;
    }
    poisciPare(args[0], args[1]);
  }
}
