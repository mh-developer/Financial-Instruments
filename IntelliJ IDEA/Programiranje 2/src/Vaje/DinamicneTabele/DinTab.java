package Vaje.DinamicneTabele;
import java.util.Collection;

/**
 *
 * @author Alenka
 */
public class DinTab {

    public static void main(String[] args) {
        final int STEVILO = 100000;
        long zacetek, konec;
        Collection seznam = new DinamicnaTabela();
        Collection podseznam = new DinamicnaTabela();
        zacetek = System.currentTimeMillis();
        for (int i = 0; i < STEVILO; i++) {
            int stevilo = (int) (Math.random() * 201) - 100;
            seznam.add(stevilo);
            if (i % 5 == 0) {
                podseznam.add(stevilo);
            }
        }
        konec = System.currentTimeMillis();
        System.out.printf("Za izgradnjo seznama %d naključnih števil smo potrebovali %d ms.\n", STEVILO, konec - zacetek);
        try {
            System.out.print("Elementi seznama: [ ");
            for (Object stevilo : seznam) {
                System.out.printf("%d ", (int) stevilo);
            }
            System.out.printf("]\n");
            System.out.print("Elementi drugega seznama: [ ");
            for (Object stevilo : podseznam) {
                System.out.printf("%d ", (int) stevilo);
            }
            System.out.printf("]\n");

            System.out.printf("Seznam %s prazen\n", seznam.isEmpty() ? "je" : "ni");

            System.out.printf("Seznam ima %d elementov in %s 5\n", seznam.size(), seznam.contains(5) ? "vsebuje element" : "ne vsebuje elementa");

            Object tretji = null;
            tretji = ((DinamicnaTabela) seznam).vrniElement(2);
            if (seznam.remove(tretji)) {
                System.out.printf("Element %s je odstranjen\n", tretji.toString());
            } else {
                System.out.printf("Elementa %s ni bilo v seznamu\n", tretji.toString());
            }

            System.out.print("Elementi seznama: [ ");
            for (Object stevilo : seznam) {
                System.out.printf("%d ", (int) stevilo);
            }
            System.out.printf("]\n");

            seznam.removeAll(podseznam);
            System.out.print("Elementi seznama: [ ");
            for (Object stevilo : seznam) {
                System.out.printf("%d ", (int) stevilo);
            }
            System.out.printf("]\n");

            seznam.addAll(podseznam);
            System.out.print("Elementi seznama: [ ");
            for (Object stevilo : seznam) {
                System.out.printf("%d ", (int) stevilo);
            }
            System.out.printf("]\n");

            //seznam.add(null);
            seznam.clear();
            seznam.toArray();
            seznam.retainAll(null);
        } catch (IzjemaNepodprteOperacije ni) {
            System.out.printf("NEPODPRTA OPERACIJA: %s\n", ni.getMessage());
        } catch (Exception e) {
            System.out.printf("NAPAKA: %s\n", e.getMessage());
        }
    }

}
