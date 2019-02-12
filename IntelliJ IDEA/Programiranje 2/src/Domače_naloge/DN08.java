package Domače_naloge;

import java.io.File;
import java.util.Scanner;

public class DN08 {

    public static void main(String[] args) throws Exception {
        Planet[] planeti = new Planet[9];

        Scanner s = new Scanner(new File(args[0]));
        int id = 0;
        while (s.hasNextLine()) {
            String planetVDatoteki = s.nextLine();
            if (planetVDatoteki.contains(":")) {
                String[] podatkiOPlanetu = planetVDatoteki.split(":");
                Planet planet = new Planet(podatkiOPlanetu[0], Integer.parseInt(podatkiOPlanetu[1]));
                planeti[id++] = planet;
            }
        }
        s.close();

        String[] izpisPlanetov = args[1].split("\\+");
        double vsota = 0;

        for (int i = 0; i < izpisPlanetov.length; i++) {
            for (int j = 0; j < planeti.length; j++) {
                vsota += izpisPlanetov[i].toLowerCase().equals(planeti[j].imePlaneta().toLowerCase()) ? planeti[j].povrsina() : 0;
            }
        }

        System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2\n", args[1], vsota / 1000000);
    }
}


class Planet {
    private String ime;
    private int radij;

    Planet(String ime, int radij) {
        this.ime = ime;
        this.radij = radij;
    }

    String imePlaneta() {
        return this.ime;
    }

    double povrsina() {
        return 4 * Math.PI * Math.pow(this.radij, 2);
    }
}
