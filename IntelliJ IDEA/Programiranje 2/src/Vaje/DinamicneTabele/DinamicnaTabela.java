package Vaje.DinamicneTabele;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Alenka
 */
public class DinamicnaTabela implements Collection {

    private Object[] tabela; // v tabeli hranimo poljubne elemente
    int zadnjiElement;       // označuje naslednjo prazno pozicijo v tabeli (oz. število elementov v tabeli)
    int velikostTabele;      // določa trenutno velikost tabele (po potrebi jo spremenimo)

    // konstruktor brez argumentov ustvari tabelo privzete velikosti 10
    public DinamicnaTabela() {
        this(10);
    }

    // konstruktor ustvari tabelo take začetne velikosti, kot jo določa podan parameter n
    public DinamicnaTabela(int n) {
        this.velikostTabele = n;
        this.tabela = new Object[this.velikostTabele];
        this.zadnjiElement = 0;
    }

    @Override
    public int size() {
        return this.zadnjiElement;
    }

    @Override
    public boolean isEmpty() {
        return (this.zadnjiElement == 0);
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) { // tabela ne hrani elementov null, zato se sproži izjema
            throw new NullPointerException("Element seznama ne sme biti null.");
        }
        // sprehodimo se preko cele tabele, dokler ne najdemo iskanega elementa
        for (int i = 0; i < this.zadnjiElement; i++) {
            if (this.tabela[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new DinamicniIterator(this); // razred DinamicniIterator se zna sprehoditi po naši tabeli
    }

    // vrne n-ti element v tabeli oz. null, če elementa ni
    public Object vrniElement(int n) {
        if ((n < this.velikostTabele) && (n >= 0)) {
            return this.tabela[n];
        }
        return null;
    }

    // poveča tabelo tako, da nova tabela hrani en element več (velikost tabele se poveča za ena)
    private void povecajTabeloZaEna() {
        Object[] tabela1 = new Object[this.velikostTabele + 1]; // kapaciteto tabelo povečamo za en element
        // prepišemo obstoječe elemente v novo tabelo
        for (int i = 0; i < this.zadnjiElement; i++) {
            tabela1[i] = this.tabela[i];
        }
        this.tabela = tabela1; // novo tabelko priredimo atrubutu tabela
        this.velikostTabele += 1;
    }

    // poveča tabelo tako, da nova tabela hrani dvakrat več elementov (velikost tabele se podvoji)
    private void povecajTabeloKratDva() {
        Object[] tabela1 = new Object[2 * this.velikostTabele]; // kapaciteto tabelo podvojimo
        // prepišemo obstoječe elemente v novo tabelo
        for (int i = 0; i < this.zadnjiElement; i++) {
            tabela1[i] = this.tabela[i];
        }
        this.tabela = tabela1; // novo tabelko priredimo atrubutu tabela
        this.velikostTabele = 2 * this.velikostTabele;
    }

    @Override
    public boolean add(Object e) {
        if (e == null) { // tabela ne hrani elementov null, zato se sproži izjema
            throw new NullPointerException("Dodani element ne sme biti null.");
        }
        // preveri, ali je še prostor v tabeli; če ga ni, povečaj tabelo
        if (this.zadnjiElement >= this.velikostTabele) {
            //povecajTabeloZaEna();
            povecajTabeloKratDva();
        }
        this.tabela[this.zadnjiElement] = e;
        this.zadnjiElement++;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c == null) {
            return false;
        }
        // sprehodi se preko zbirke c in dodajaj elemente zbirke v tabelo
        for (Object o : c) {
            this.add(o);
        }
        return true;
    }

    // iz tabele odstrani n-ti element in "zapolni luknjo"
    private void odstraniIzTabele(int n) {
        // vse elemente od elementa (n+1) pa do konca tabele premakni za eno mesto naprej v tabeli
        for (int i = n; i < this.zadnjiElement - 1; i++) {
            this.tabela[i] = this.tabela[i + 1];
        }
        this.tabela[this.zadnjiElement - 1] = null;
        this.zadnjiElement--;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) { // tabela ne hrani elementov null, zato se sproži izjema
            throw new NullPointerException("Odstranjen element ne sme biti null.");
        }
        // če je tabela prazna, ne briši in vrni false
        if (this.isEmpty()) {
            return false;
        }
        // poišči prvo pojavitev elementa v tabeli in ga zbriši ter vrni true
        for (int i = 0; i < this.zadnjiElement; i++) {
            if (this.tabela[i].equals(o)) {
                odstraniIzTabele(i);
                return true;
            }
        }
        // če elementa ni bilo v tabeli, vrni false
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            return false;
        }
        // sprehodi se preko zbirke c in briši elemente zbirke iz tabele
        for (Object o : c) {
            this.remove(o);
        }
        return true;
    }

    @Override
    public void clear() {
        throw new IzjemaNepodprteOperacije("Razred DinamicnaTabela ne podpira operacije clear.");
    }

    @Override
    public Object[] toArray() {
        throw new IzjemaNepodprteOperacije("Razred DinamicnaTabela ne podpira operacije toArray.");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new IzjemaNepodprteOperacije("Razred DinamicnaTabela ne podpira operacije toArray.");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new IzjemaNepodprteOperacije("Razred DinamicnaTabela ne podpira operacije containsAll.");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new IzjemaNepodprteOperacije("Razred DinamicnaTabela ne podpira operacije retainAll.");
    }

}
