package Domače_naloge;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;


/*



StdLib
Knjižnico StdLib in navodila za njeno uporabo najdete tukaj. Jar knjižnice lahko dobite tukaj.

Če uporabljate Eclipse ali NetBeans, odprite mapo Library in z desnim klikom dodajte prenešeni jar.

Če uporabljate program IDEA, odprite nastavitve projekta (File/Project Structure.../Project Settings/Modules/Dependencies) in dodajte prenešeni jar. Priporočamo, da si prenesete ta jar, saj omogoča uporabo v paketih.



--------------------------------------------------





Gibanje cen finančnih inštrumentov
Gibanje finančnih instrumentov - cene delnic, valutnih parov, kriptovalut, ... - predstavimo s serijo japonskih svečk (spodnja slika). Vsaka svečka predstavlja določen časovni interval (v tej nalogi bomo uporabljali minutni interval, kljub temu, da se uporabljajo tudi 5 minutni, 15 minutni, pol urni, urni, ...).

candlestick example

Vrednost open predstavlja vrednost finančnega inštrumenta (npr. bitcoina) na začetku intervala; vrednosti high in low predstavljata najvišjo in najnižjo vrednost finančnega inštrumenta na danem intervalu; vrednost close predstavlja vrednost finančnega inštrumenta ob koncu intervala.

Podatki
Podatki, ki jih boste uporabljali v nalogi, bodo zapisani v datoteki tipa csv. Ime datoteke nam pove, za kateri valutni par oziroma kriptovaluto so podatki v datoteki.

Primer: Datoteka EURUSD.csv vsebuje podatke o razmerju med valutama EUR in USD.

Format posamezne svečke (vrstice) je:

datum,čas,open,high,low,close,volume
(Pri nas podatka volume ne bomo uporabljali, lahko pa predstavlja količino kupljenih in prodanih enot)

Podatka datum in čas določata začetek minute, katero predstavlja svečka. Če svečka na določenem intervalu ne obstaja, za tisti čas velja close vrednost zadnje svečke, ki obstaja pred tem časom.

Pri branju podatkov lahko predpostavite, da bo obseg podatkov za posamezni finančni inštrument največ en mesec!

Na koncu je priložena datoteka z izsekom podatkov, s katerimi bomo testirali vaše naloge.



Naloge
Napišite program za izpis podatkov o gibanju in analizi valut. Vse razrede in metode implementirajte v datoteki DN09.java. Razred DN09 naj vsebuje metodo main(), ki bo omogočala testiranje vseh ostalih metod. Prvi argument programa bo ime naloge, pomen ostalih argumentov pa je razviden iz opisa pri posamezni nalogi. Vse decimalne podatke izpišite na sedem mest natančno.

Na učilnico oddajte le datoteko DN09.java, ki naj vsebuje vse zahtevane razrede!

DateTime
Za potrebe te naloge napišite pomožni razred DateTime, ki vsebuje atribute leto, mesec, dan, ura in minuta. Razred DateTime naj vsebuje smiseln konstruktor (ali več konstruktorjev) in sledeče metode, ki vam bodo koristile v nadaljevanju:

isGreater, ki kot argument sprejme DateTime ter vrne true, če je lastna vrednost objekta manjša od vrednosti podanega objekta.
isLower, ki preveri, če je lastna vrednost objekta manjša od vrednosti podanega objekta.
isEqual preveri če je vrednost podanega datuma enaka svoji vrednosti.
toString ki vrne datum oblike 1. 4. 2018 13.37:
Ob klicu programa:

java DN09 dateTime 2018.03.13 17:42
naj program izpiše datum in čas v skladu s slovenskim pravopisom:

13. 3. 2018 17.42
Candle
Napišite razred Candle, ki vsebuje atribute: dateTime, open, high, low in close. Razred naj vsebuje smiseln konstruktor in getter metode za vse atribute.

Ob klicu programa:

java DN09 candle 2018.03.05 02:08 1.226140 1.226270 1.226080 1.226210 0
naj program izpiše čas ter povprečno vrednost svečke (aritmetično sredino vrednosti open, high, low in close):

5. 3. 2018 02.08: 1.226175
Bullish & Bearish
Napišite metodi:

isBullish, ki vrne true, če je svečka bikova (cena ob koncu intervala je višja od cene na začetku intervala),
isBearish, ki vrne true, če je svečka medvedja (cena ob koncu intervala je nižja od cene na začetku intervala).


FinancialInstrument
Napišite razred FinancialInstrument, ki vsebuje atribute candles, currency1 in currency2. Razred naj vsebuje primeren konstruktor, ki sprejme ime datoteke in oznake valut, prebere podano datoteko ter si zapomni podatke. Atributa currency1 in currency2 vedno vsebujeta tri znake, razberete ju lahko iz imena podane datoteke.

V razredu napišite tri metode movingAverage, najvisjaVrednost in najnizjaVrednost. Po potrebi lahko napišete tudi dodatne metode, ki bi vam prišle prav. Iz razreda FinancialInstrument izpeljite tudi dva razreda CurrencyPair in CryptoCurrency.

MovingAverage
Napišite metodo movingAverage, ki sprejme argumenta:

dateTime, ki določa za katero svečko se računa drseče povprečje,
windowSize določa koliko svečk do želenega trenutka vzamemo za izračun drsečega povprečja (vključujoč svečko na danem intervalu, če ta obstaja, sicer pa toliko predhodnih svečk) za katere se povprečje računa.
Drseče povprečje se računa kot aritmetično povprečje želene količine close vrednosti svečk.

Ob klicu programa:

java DN09 movingAverage 30 EURUSD.csv 2018.03.14 12:34
naj program vrne:

1.237020
Drugi argument (30) predstavlja vrednost windowSize.

Najvišja in najnižja vrednost
Napišite metodi maxValue, minValue, ki za dani interval (vključujoč robni čas) izpišeta najvišjo oziroma najnižjo vrednost.

Ob klicu programa:

java DN09 najvisja EURUSD.csv 2018.03.13 08:00 2018.03.14 08:00
naj program vrne:

Najvisja vrednost za dani interval: 1.241240
Druga možnost klica programa:

java DN09 najnizja EURUSD.csv 2018.03.13 08:00 2018.03.14 08:00
Program naj v drugem primeru klica vrne ustrezno popravljeno besedilo.



CurrencyPair
Iz razreda FinancialInstrument izpeljite razred CurrencyPair. Napišite smiseln konstruktor in uporabite tudi klic konstruktorja nadrazreda. Razred naj vsebuje tudi dodatni metodi nonBusinessDays in masterCandles.

Trgovanja prosti dnevi
Napišite metodo nonBusinessDays, ki za dani interval, vrne število dni, v katerih se ni trgovalo. Za dan, v katerem se ni trgovalo, se smatra, če za ta dan skupno za vsaj 6 ur ni podatkov.

Ob klicu programa:

java DN09 nonBusiness EURUSD.csv 2018.03.13 00:00 2018.03.15 23:59
naj program vrne:

Trgovanja prostih dni: 1
Če v intervalu ni zajet cel dan, se prag za netrgovalni dan sorazmerno zmanjša.

Master Candles
Napišite metodo masterCandles, ki prešteje število master svečk na podanem intervalu. Master svečke so svečke, katerih najvišja in najnižja vrednost sta višji in nižji od vsaj štirih svečk, ki ji sledijo.

candlestick chart example

Ob klicu programa:

java DN09 masterCandles EURUSD.csv 2018.03.13 08:00 2018.03.13 18:00
naj program vrne:

Med 13. 3. 2018 08.00 in 13. 3. 2018 18.00 je bilo 15 master sveck.
Pozor! Upoštevajte pravilno samostalniško število.



CryptoCurrency
Iz razreda FinancialInstrument izpeljite razred CryptoCurrency. Cene kriptovalut bodo vedno izražene v ameriškem dolarju (USD). Napišite smiseln konstruktor (brez podatka o drugi valuti) in uporabite tudi klic konstruktorja nadrazreda.

Pretvarjanje valut
Napišite metodo convert, ki za želen čas vrne vrednost kriptovalute v drugi valuti, podani kot objekt tipa CurrencyPair.

Ob klicu programa:

java DN09 convert BTC.csv EURUSD.csv 2018.03.14 22:22
naj program vrne:

Kriptovaluta 'BTC' je bila 14. 3. 2018 22.22 vredna 6508.254 EUR
Vrednosti kriptovalut naj bodo zapisane na tri decimalna mesta natančno.



Izris
V razredu FinancialInstrument napišite metodo izris, ki prejme dolžino okna za drseče povprečje in obdobje za katerega naj izriše svečke ter drseče povprečje. Metoda naj prikaže sliko za dano obdobje s pomočjo knjižnice stdlib.

Če je svečka bikova, naj bo njeno telo bele barve, če pa je medvedova, naj bo njeno telo črne barve.

Ob klicu programa:

java DN09 izris EURUSD.csv 30 2018.03.14 10:15 2018.03.14 10:30
naj program prikaže podatke na približno tak način:

candlestick chart example

Predpostavljate lahko, da bo potrebno prikazati največ 30 svečk.
 */

public class DN09 {
    public static void main(String[] args) throws Exception {

        switch (args[0]) {
            case "dateTime":
                DateTime a = new DateTime(args[1], args[2]);
                System.out.println(a.toString());
                break;
            case "candle":
                Candle c = new Candle(
                        args[1],
                        args[2],
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]),
                        Double.parseDouble(args[6])
                );
                System.out.printf("%s: %7f\n", c.getDateTime().toString(), (c.getOpen() + c.getLow() + c.getHigh() + c.getClose()) / 4.0);
                break;
            case "movingAverage":
                FinancialInstrument fin = new FinancialInstrument(args[2]);
                System.out.printf("%7f\n", fin.movingAverage(new DateTime(args[3], args[4]), Integer.parseInt(args[1])));
                break;
            case "najvisja":
                FinancialInstrument finNajv = new FinancialInstrument(args[1]);
                System.out.printf("Najvisja vrednost za dani interval: %7f\n", finNajv.maxValue(new DateTime(args[2], args[3]),
                                                                                                   new DateTime(args[4], args[5]))
                );
                break;
            case "najnizja":
                FinancialInstrument finNajn = new FinancialInstrument(args[1]);
                System.out.printf("Najnizja vrednost za dani interval: %7f\n", finNajn.minValue(new DateTime(args[2], args[3]),
                                                                                                   new DateTime(args[4], args[5]))
                );
                break;
            case "nonBusiness":
                CurrencyPair cp = new CurrencyPair(args[1]);
                System.out.printf("Trgovanja prostih dni: %d\n", cp.nonBusinessDays(new DateTime(args[2], args[3]),
                                                                                       new DateTime(args[4], args[5]))
                );
                break;
            case "masterCandles":
                CurrencyPair cpM = new CurrencyPair(args[1]);
                DateTime dt1 = new DateTime(args[2], args[3]);
                DateTime dt2 = new DateTime(args[4], args[5]);
                int masterSvecke = cpM.masterCandles(dt1, dt2);

                String samostalniskoSt = masterSvecke == 1 ? "je bila" :
                                         masterSvecke == 2 ? "sta bili" :
                                         masterSvecke == 3 || masterSvecke == 4 ? "so bile" :
                                         masterSvecke > 5 ? "je bilo" :
                                                            "je bilo";

                String samostalniskoStSveck = masterSvecke == 1 ? "svecka" :
                                              masterSvecke == 2 ? "svecki" :
                                              masterSvecke == 3 || masterSvecke == 4 ? "svecke" :
                                              masterSvecke > 5 ? "sveck" :
                                                                 "sveck";

                System.out.printf("Med %s in %s %s %d master %s.\n", dt1.toString(),
                                                                        dt2.toString(),
                                                                        samostalniskoSt,
                                                                        masterSvecke,
                                                                        samostalniskoStSveck
                );
                break;
            case "convert":
                CryptoCurrency cc = new CryptoCurrency(args[1]);
                DateTime dt = new DateTime(args[3], args[4]);
                System.out.printf("Kriptovaluta '%s' je bila %s vredna %7.3f %s\n", cc.getCurrency1(),
                                                                                       dt.toString(),
                                                                                       cc.convert(new CurrencyPair(args[2]), dt),
                                                                                       cc.getCurrency2()
                );
                break;
            case "izris":
                FinancialInstrument finI = new FinancialInstrument(args[1]);
                finI.izris(
                        Integer.parseInt(args[2]),
                        new DateTime(args[3], args[4]),
                        new DateTime(args[5], args[6])
                );
                break;
        }
    }
}


class DateTime {
    private int leto;
    private int mesec;
    private int dan;
    private int ura;
    private int minuta;
    private String time;

    DateTime(String date, String time) {
        this.leto = Integer.parseInt(date.split("[.]")[0]);
        this.mesec = Integer.parseInt(date.split("[.]")[1]);
        this.dan = Integer.parseInt(date.split("[.]")[2]);
        this.ura = Integer.parseInt(time.split("[:]")[0]);
        this.minuta = Integer.parseInt(time.split("[:]")[1]);
        this.time = time.replace(":", ".");
    }

    public int getUra() {
        return this.ura;
    }

    public int getMinuta() {
        return this.minuta;
    }

    public boolean isGreater(DateTime dt) {
        boolean leto = (this.leto > dt.leto);
        boolean mesec = (this.mesec > dt.mesec && this.leto >= dt.leto);
        boolean dan = (this.dan > dt.dan && this.mesec >= dt.mesec && this.leto >= dt.leto);
        boolean ura = (this.ura > dt.ura && this.dan >= dt.dan && this.mesec >= dt.mesec && this.leto >= dt.leto);
        boolean minuta = (this.minuta > dt.minuta && this.ura >= dt.ura && this.dan >= dt.dan && this.mesec >= dt.mesec && this.leto >= dt.leto);

        return leto || mesec || dan || ura || minuta;
    }

    public boolean isLower(DateTime dt) {
        return !isGreater(dt) && !isEqual(dt);
    }

    public boolean isEqual(DateTime dt) {
        return this.leto == dt.leto && this.mesec == dt.mesec && this.dan == dt.dan && this.ura == dt.ura && this.minuta == dt.minuta;
    }

    public String toString() {
        return this.dan + ". " + this.mesec + ". " + this.leto + " " + this.time;
    }
}

class Candle {
    private DateTime dateTime;
    private double open;
    private double high;
    private double low;
    private double close;

    public Candle(String date, String time, double open, double high, double low, double close) {
        this.dateTime = new DateTime(date, time);
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public double getOpen() {
        return this.open;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public double getClose() {
        return this.close;
    }

    public boolean isBullish() {
        return this.open < this.close;
    }

    public boolean isBearish() {
        return this.open > this.close;
    }
}


class FinancialInstrument {
    private Candle[] candles = new Candle[24 * 60 * 31];
    private String currency1;
    private String currency2;

    FinancialInstrument(String candles) throws Exception {
        Scanner s = new Scanner(new File(candles));

        int id = 0;
        while (s.hasNextLine()) {
            String[] vrstica = s.nextLine().split("[,]");
            Candle c = new Candle(
                    vrstica[0],
                    vrstica[1],
                    Double.parseDouble(vrstica[2]),
                    Double.parseDouble(vrstica[3]),
                    Double.parseDouble(vrstica[4]),
                    Double.parseDouble(vrstica[5])
            );
            this.candles[id++] = c;
        }
        s.close();

        char[] c1 = candles.split("[.]")[0].toCharArray();
        this.currency1 = c1.length >= 3 ? String.format("%c%c%c", c1[0], c1[1], c1[2]) : "";
        this.currency2 = c1.length >= 6 ? String.format("%c%c%c", c1[3], c1[4], c1[5]) : "";
    }

    public Candle[] getCandles() {
        return this.candles;
    }

    public String getCurrency1() {
        return this.currency1;
    }

    public String getCurrency2() {
        return this.currency2;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public double movingAverage(DateTime dateTime, int windowSize) {
        double vsota = 0;
        int id = getIndexOf(dateTime);

        for (int i = id; i > id - windowSize && i >= 0; i--) {
            vsota += this.candles[i].getClose();
        }

        return vsota / windowSize * 1.0;
    }

    public double maxValue(DateTime dt1, DateTime dt2) {
        double max = this.candles[getIndexOf(dt1)].getHigh();

        for (int i = getIndexOf(dt1); i <= getIndexOf(dt2); i++) {
            if (max < this.candles[i].getHigh())
                max = this.candles[i].getHigh();
        }

        return max;
    }

    public double minValue(DateTime dt1, DateTime dt2) {
        double min = this.candles[getIndexOf(dt1)].getLow();

        for (int i = getIndexOf(dt1); i <= getIndexOf(dt2); i++) {
            if (min > this.candles[i].getLow())
                min = this.candles[i].getLow();
        }

        return min;
    }

    public int getIndexOf(DateTime dt) {

        for (int i = 0; i < this.candles.length; i++) {
            if (this.candles[i] == null)
                return i - 1;

            if (this.candles[i].getDateTime().isEqual(dt))
                return i;

            if (this.candles[i].getDateTime().isGreater(dt) && i > 0)
                return i - 1;
        }
        return 0;
    }

    public double getCloseValue(DateTime dt) {
        return this.candles[getIndexOf(dt)].getClose();
    }



    double getCoordinatesOfCandle(double min, double max, double value) {
        return ((value - min) / (max - min)) * 100;
    }

    public void izris(int windowSize, DateTime dt1, DateTime dt2) {

        StdDraw.setCanvasSize(40 * 30, 20 * 30);
        StdDraw.setScale(-15, 115);
        StdDraw.clear();


        // max text
        StdDraw.text(-5, 100, String.format("%7f", maxValue(dt1, dt2)));
        // min text
        StdDraw.text(-5, 0, String.format("%7f", minValue(dt1, dt2)));
        // izpis valut
        StdDraw.text(100 / 2, 105, String.format("%s%s", getCurrency1(), getCurrency2()));

        // omejilni črti
        StdDraw.setPenColor(Color.lightGray);
        StdDraw.line(0, 100, 105, 100);
        StdDraw.line(0, 0, 105, 0);


        double razmik = 4;
        double resize = 100.0 / (getIndexOf(dt2) - getIndexOf(dt1));

        // začetni datum
        StdDraw.setPenColor(Color.lightGray);
        StdDraw.line(razmik, 0, razmik, -2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(razmik, -7, this.candles[getIndexOf(dt1)].getDateTime().toString());

        // izris svečk
        for (int i = getIndexOf(dt1); i < getIndexOf(dt2); i++) {

            double openY = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), this.candles[i].getOpen());
            double highY = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), this.candles[i].getHigh());
            double lowY = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), this.candles[i].getLow());
            double closeY = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), this.candles[i].getClose());
            double movingAverageY = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), movingAverage(this.candles[i].getDateTime(), windowSize));
            double movingAverageY2 = getCoordinatesOfCandle(minValue(dt1, dt2), maxValue(dt1, dt2), movingAverage(this.candles[i - 1].getDateTime(), windowSize));


            StdDraw.setPenColor(Color.BLACK);
            StdDraw.line(razmik, lowY, razmik, highY);

            StdDraw.setPenColor(this.candles[i].isBearish() ? Color.BLACK : Color.WHITE);
            StdDraw.filledRectangle(razmik, (openY + closeY) / 2.0, (resize) / 2.0, Math.abs(openY - closeY) / 2.0);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.rectangle(razmik, (openY + closeY) / 2.0, (resize) / 2.0, Math.abs(openY - closeY) / 2.0);

            if (i > getIndexOf(dt1)) {
                StdDraw.setPenColor(Color.CYAN);
                StdDraw.line(razmik - resize, movingAverageY2, razmik, movingAverageY);
            }

            razmik += resize;
        }

        // končni datum
        StdDraw.setPenColor(Color.lightGray);
        StdDraw.line(razmik - resize, 0, razmik - resize, -2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(razmik - resize, -7, this.candles[getIndexOf(dt2)].getDateTime().toString());

    }
}


class CurrencyPair extends FinancialInstrument {

    public CurrencyPair(String candles) throws Exception {
        super(candles);
    }

    public int nonBusinessDays(DateTime dt1, DateTime dt2) {
        double prag = ((dt2.getUra() * 60 + dt2.getMinuta()) - (dt1.getUra() * 60 + dt1.getMinuta())) * 0.25;
        int countDays = 0;

        for (int i = getIndexOf(dt1); i < getIndexOf(dt2); i++) {
            if ((super.getCandles()[i + 1].getDateTime().getUra() * 60 + super.getCandles()[i + 1].getDateTime().getMinuta()) -
                    (super.getCandles()[i].getDateTime().getUra() * 60 + super.getCandles()[i].getDateTime().getMinuta()) > prag) {

                countDays++;
            }
        }

        return countDays;
    }

    private int masterCandlesStevec(int j) {
        int stevec = 0;

        for (int k = j + 1; k < j + 5; k++) {
            if (super.getCandles()[j].getHigh() > super.getCandles()[k].getHigh() &&
                super.getCandles()[j].getLow() < super.getCandles()[k].getLow()) {

                stevec++;
            }
        }

        if (stevec == 4)
            return 1;
        else
            return 0;

    }

    public int masterCandles(DateTime dt1, DateTime dt2) {
        int master = 0;

        for (int i = getIndexOf(dt1); i <= getIndexOf(dt2); i++) {
            master += masterCandlesStevec(i);
        }

        return master;
    }
}


class CryptoCurrency extends FinancialInstrument {
    public CryptoCurrency(String candles) throws Exception {
        super(candles);
    }

    public double convert(CurrencyPair cp, DateTime dt) {
        setCurrency2(cp.getCurrency1());
        return this.getCloseValue(dt) / cp.getCloseValue(dt);
    }
}