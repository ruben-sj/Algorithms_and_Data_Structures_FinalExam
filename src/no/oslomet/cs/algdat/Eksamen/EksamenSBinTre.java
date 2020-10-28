package no.oslomet.cs.algdat.Eksamen;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringJoiner;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    // Op2
    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    // Op2
    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    // Op2
    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        // Op1
        // Kopier programkode 5.2 3a)
            // + endre forledre referansen slik at den får korrekt verdi
                    // se; foreldrereferanse i klassen TreeSet i java.util
        // sjekk at kode er feilfri (ikke kaster unntak), se doc

        throw new UnsupportedOperationException("Skallkode skrevet");
    }

    public boolean fjern(T verdi) {
        // Op6
        //

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        // Op6
        //

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        // Op2
        // Skal returnere antall forekomster av "verdi" i treet
            // OBS! Det ER tillatt med duplikater, aka. en verdi kan forekomme flere ganger
            // OBS2! Hvis veri = "null" skal metode returnere "0"
        // Test kode med trær med flere like verdier
            // Sjekk at metod gir ret svar, se; doc for et eks.

        throw new UnsupportedOperationException("Skalkode skrevet");
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        // Op3
        // OBS! Parameter "p" != "null"
        // Skal returnere første node postorden med "p" som rot
        // OBS2! Hvis "p" er den siste i postorden skal det returneres "null"

        throw new UnsupportedOperationException("Skallkode skrevet");
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        // Op3
        // OBS! Parameter "p" != "null"
        // Skal returnere den noden som kommer etter "p" i "postorden"
        // OBS2! Hvis "p" er den siste i postorden skal det returneres "null"

        throw new UnsupportedOperationException("Skallkode skrevet");
    }

    public void postorden(Oppgave<? super T> oppgave) {
        // Op4
        //

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        // Op4
        //

        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public ArrayList<T> serialize() {
        // Op5
        //

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        // Op5
        //

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
