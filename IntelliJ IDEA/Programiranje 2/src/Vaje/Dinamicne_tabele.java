package Vaje;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Dinamicne_tabele {
    public static void main(String[] args) {

    }
}

class DinamicnaTabela implements Collection {
    private Object[] tabela;
    private int inx = 0;

    public DinamicnaTabela() {
        this.tabela = new Object[10];
    }

    public DinamicnaTabela(int velikost) {
        this.tabela = new Object[velikost];
    }

    @Override
    public int size() {
        return this.inx;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object i : this.tabela)
            if (i == o)
                return true;
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        if (this.tabela.length < this.size()) {
            Object[] vecjaTabela = new Object[this.tabela.length + 1];
            for (int i = 0; i < this.tabela.length; i++) {
                vecjaTabela[i] = this.tabela[i];
            }
            this.tabela = vecjaTabela;
        }
        this.tabela[this.inx++] = o;


        return true;
    }

    @Override
    public boolean addAll(Collection t) {
        for (Object o : t) {
            this.add(o);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (Object i : this.tabela) {
            if (i == o) {
                i = null;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection t) {
        for (Object i : t) {
            remove(i);
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        throw new RuntimeException();
    }

    @Override
    public Object[] toArray() {
        throw new RuntimeException();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new RuntimeException();
    }

    @Override
    public void clear() {
        throw new RuntimeException();
    }

    @Override
    public boolean removeIf(Predicate predicate) {
        throw new RuntimeException();
    }

    @Override
    public Spliterator spliterator() {
        throw new RuntimeException();
    }

    @Override
    public Stream stream() {
        throw new RuntimeException();
    }

    @Override
    public Stream parallelStream() {
        throw new RuntimeException();
    }

    @Override
    public boolean containsAll(Collection collection) {
        throw new RuntimeException();
    }
}
