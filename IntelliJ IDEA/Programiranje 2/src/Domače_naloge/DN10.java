package Domače_naloge;

import java.io.File;
import java.util.*;

public class DN10 {
    TreeMap<String, Integer> besede;

    public static void main(String[] args) throws Exception {
        TreeMap<String, Integer> besede = preberiDatoteko(args[0]);
        //Besede besede = new Besede(preberiDatoteko(args[0]));

        switch (args[1]) {
            case "1":
                for (String b : besede.keySet()) {
                    System.out.printf("%-2d    %s\n", besede.get(b), b);
                }
                break;
            case "2":
                ArrayList<Besede> a = new ArrayList<>();
                for (String b : besede.keySet()) {
                    a.add(new Besede(b, besede.get(b)));
                }

                Collections.sort(a);

                for (Besede b : a) {
                    System.out.printf("%-2d    %s\n", b.getValue(), b.getKey());
                }
                break;
        }
    }


    public static TreeMap<String, Integer> preberiDatoteko(String datoteka) throws Exception {
        Scanner s = new Scanner(new File(datoteka));
        TreeMap<String, Integer> besede = new TreeMap<>();

        while (s.hasNext()) {
            String beseda = s.next().replaceAll("[.;:,?()!-]", "");
            besede.put(beseda, besede.containsKey(beseda) ? besede.get(beseda) + 1 : 1);
        }
        s.close();

        return besede;
    }
}

class Besede implements Comparable<Besede> {
    private String key;
    private Integer value;

    public Besede(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int compareTo(Besede value2) {
        return value2.value - this.value;
    }
}
