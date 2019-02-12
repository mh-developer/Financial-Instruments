package Domače_naloge;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class DN11 {

    public static void main(String[] args) {
        String[] sb = preberiDatoteko(args[0]).toString().trim().split(" ");
        int n = Integer.parseInt(args[1]);
        TreeMap<Integer, String> vrstice = new TreeMap<>();

        switch (args[2]) {
            case "1":
                StringBuffer vrstica = new StringBuffer();
                int stevec = 0;

                for (int i = 0; i < sb.length; i++) {

                    if (stevec + sb[i].length() <= n) {
                        stevec += sb[i].length() + 1;
                        vrstica.append(sb[i] + " ");

                    } else {
                        System.out.println(vrstica.toString().trim());
                        vrstica = new StringBuffer();
                        vrstica.append(sb[i] + " ");
                        stevec = sb[i].length() + 1;
                    }
                }
                System.out.println(vrstica.toString().trim());
                break;
            case "x":
                StringBuffer vrstica1 = new StringBuffer();
                int stevec1 = 0;
                int st = 1;

                for (int i = 0; i < sb.length; i++) {

                    if (stevec1 + sb[i].length() <= n) {
                        stevec1 += sb[i].length() + 1;
                        vrstica1.append(sb[i] + " ");

                    } else {
                        vrstice.put(st++, vrstica1.toString().trim());
                        vrstica1 = new StringBuffer();
                        vrstica1.append(sb[i] + " ");
                        stevec1 = sb[i].length() + 1;
                    }
                }
                vrstice.put(st, vrstica1.toString().trim());

                for (Integer i : vrstice.keySet()) {
                    //System.out.println(i + "     " + vrstice.get(i));
                    String[] besede = vrstice.get(i).split(" ");
                    int st_presledkov = n % (vrstice.get(i).length() - (besede.length - 1));
                    int dodani_presledki = 0;
                    StringBuffer _vrstica = new StringBuffer();

                    for (int j = 0; j < st_presledkov; j++) {
                        if (st_presledkov >= dodani_presledki) {
                            for (int k = 0; k < besede.length - 1; k++) {
                                if (st_presledkov > dodani_presledki) {
                                    besede[k] += " ";
                                    dodani_presledki++;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }

                    for (String _beseda : besede) {
                        _vrstica.append(_beseda);
                    }
                    System.out.println(_vrstica.toString());

                }
                break;
        }
    }


    public static StringBuilder preberiDatoteko(String datoteka) {
        StringBuilder besedilo = new StringBuilder();

        try (Scanner s = new Scanner(new File(datoteka))) {
            while (s.hasNextLine()) {
                besedilo.append(s.nextLine() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return besedilo;
    }

}
