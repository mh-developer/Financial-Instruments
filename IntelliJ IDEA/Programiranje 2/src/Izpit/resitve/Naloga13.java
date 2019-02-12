package Izpit.resitve;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Peter Gabrovšek
 */
public class Naloga13 {

  public static void main(String[] args) throws IOException {
    String vir = args[0];

    File file = new File(vir);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNext()) {
      String word = scanner.next();
      if (word.equals("color:") && scanner.hasNext()) {
        String color = scanner.next();
        if (color.charAt(0) == '#' && (color.length() == 8 || color.length() == 7)) {
          color = color.substring(0, 7);
          String rgb = hexToRGB(color);
          String hsl = hexToHSL(color);
          System.out.printf("%s -> %s -> %s\n", color, rgb, hsl);
        }
      }
    }
  }

  private static String hexToRGB(String color) {
    // pretvorba iz šestnajstiškega barvnega sistema v RGB
    int r = Integer.parseInt(color.substring(1, 3), 16);
    int g = Integer.parseInt(color.substring(3, 5), 16);
    int b = Integer.parseInt(color.substring(5, 7), 16);
    return String.format("rgb(%s, %s, %s)", r, g, b);
  }

  private static String hexToHSL(String color) {
    // pretvorba iz šestnajstiškega barvnega sistema v HSL

    // RGB komponente
    int r = Integer.parseInt(color.substring(1, 3), 16);
    int g = Integer.parseInt(color.substring(3, 5), 16);
    int b = Integer.parseInt(color.substring(5, 7), 16);

    // normirane rgb komponente
    double R = r / 255.0f;
    double G = g / 255.0f;
    double B = b / 255.0f;

    // implementirane formule za HSL
    double M = Math.max(R, Math.max(G, B));
    double m = Math.min(R, Math.min(G, B));
    double C = M - m;
    double HH = 0;
    if (M == R) {
      HH = ((G - B) / C) % 6;
    } else if (M == G) {
      HH = (B - R) / C + 2;
    } else if (M == B) {
      HH = (R - G) / C + 4;
    }

    // H-komponenta
    double H = 60 * HH;
    if (H < 0) {
      H += 360;
    }
    // L-komponenta
    double L = (M + m) / 2.0f;
    // S-komponenta
    double S = (L == 1) ? 0 : C / (1 - Math.abs(2 * L - 1));

    return String.format("hsl(%s, %s, %s)", Math.round(H), Math.round(S * 100), Math.round(L * 100));
  }
}
