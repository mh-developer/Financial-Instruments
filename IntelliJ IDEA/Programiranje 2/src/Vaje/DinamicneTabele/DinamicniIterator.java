package Vaje.DinamicneTabele;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Alenka
 */
public class DinamicniIterator implements Iterator {

    private DinamicnaTabela dinTab;
    private int trenutni = 0;

    public DinamicniIterator(DinamicnaTabela t) {
        this.dinTab = t;
    }

    @Override
    public boolean hasNext() {
        return (this.dinTab.size() > this.trenutni);
    }

    @Override
    public Object next() {
        if (this.trenutni >= this.dinTab.size()) {
            throw new NoSuchElementException();
        }
        Object o = this.dinTab.vrniElement(this.trenutni);
        this.trenutni++;
        return o;
    }

}
