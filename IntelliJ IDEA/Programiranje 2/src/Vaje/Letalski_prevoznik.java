package Vaje;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Letalski_prevoznik {

    public static void main(String[] args) {
        MrezaLetov ml = new MrezaLetov();
        ml.preberiLetalisca("viri/letalisca.txt");
        ml.preberiPovezave("viri/poleti.txt");

        ml.izpisi();
    }
}

class Letalisce {
    private String airCode;
    private String mesto;
    private String drzava;
    private TreeSet<String> prihodi = new TreeSet<>();
    private TreeSet<String> odhodi = new TreeSet<>();

    public Letalisce(String airCode, String mesto, String drzava) {
        this.airCode = airCode.toUpperCase();
        this.mesto = mesto;
        this.drzava = drzava;
    }

    public Letalisce(String airCode, String mesto, String drzava, String odhodi) {
        this.airCode = airCode.toUpperCase();
        this.mesto = mesto;
        this.drzava = drzava;
        this.odhodi.add(odhodi);
    }

    public String getAirCode() {
        return this.airCode;
    }

    public String getDrzava() {
        return this.drzava;
    }

    public String getMesto() {
        return this.mesto;
    }

    public TreeSet<String> getOdhodi() {
        return odhodi;
    }

    public TreeSet<String> getPrihodi() {
        return prihodi;
    }

    public void setPrihodi(String prihod) {
        this.prihodi.add(prihod);
    }

    public void setOdhodi(String odhod) {
        this.odhodi.add(odhod);
    }

    public String izpisOdhodov() {
        StringBuffer s = new StringBuffer();
        for (String i : this.odhodi) {
            s.append(i + " ");
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return getAirCode() + ": " + getMesto() + ", " + getDrzava() + "\n";
    }
}

class MrezaLetov {
    private TreeMap<String, Letalisce> destinacije = new TreeMap<>();

    public MrezaLetov() {

    }

    public TreeMap<String, Letalisce> getDestinacije() {
        return destinacije;
    }

    public void preberiLetalisca(String file) {
        try (Scanner s = new Scanner(new File(file))) {
            while (s.hasNextLine()) {
                String[] vrstica = s.nextLine().split(" ");
                this.destinacije.put(vrstica[0], new Letalisce(vrstica[0], vrstica[1], vrstica[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preberiPovezave(String file) {
        try (Scanner s = new Scanner(new File(file))) {
            ArrayList<String[]> prihod_odhodi = new ArrayList<>();
            while (s.hasNextLine()) {
                String[] vrstica = s.nextLine().split(" ");
                prihod_odhodi.add(vrstica);
            }

            for (String[] i : prihod_odhodi) {
                this.destinacije.put(i[0], new Letalisce(this.destinacije.get(i[0]).getAirCode(),
                        this.destinacije.get(i[0]).getMesto(),
                        this.destinacije.get(i[0]).getDrzava(),
                        i[1]));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void izpisi() {
        for (Letalisce i : this.destinacije.values()) {
            System.out.println(i.toString());
        }
    }
}