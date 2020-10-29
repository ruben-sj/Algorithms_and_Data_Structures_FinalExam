package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

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


    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        // Hente kode fra komendium av Ulf Utterud; Programkode 5.2.3 a)
        // Endring av original kode fra 5.2.3a; "q" settes som forelder i "new Node"

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        // Op6
        // Kopiere Programkode 5.2 8 d), se; pdf link
            // + endringer for at peker "forender" får korrekt verdi i alle node etter en fjerning

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        // Op6
        // Skal fjerne alle forekomster av verdi i treet
            // OBS! Duplikater er tillat, aka. en og samme verdi kan ligge flere steder i treet
        // Skal returnere antallet som ble fjernet
            // OBS! HVis treet er tomt skal det returneres "0"

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {

        // Setter count lik "0"
        int count = 0;

        Node<T> p = rot;

        // Så lenge "p" ikke er lik "null"
        while (p != null) {

            // Sammenligner verdi og "p" sin verdi
            int cmp = comp.compare(verdi, p.verdi);

            // Hvis verdi er mindre enn "p" sin verdi --> gå til venstre
            if (cmp < 0) {
                p = p.venstre;
            }

            // Hvis verdi er større en "p" sin verdi --> gå til høyre
            if (cmp >= 0) {

                // Hvis verdien er lik "p" sin verdi --> øker antall
                if (p.verdi == verdi){
                    count++;
                }

                p = p.høyre;
            }
        }

        // Returnerer count
        return count;
    }

    public void nullstill() {
        // Op6
        // Skal traverese treet i EN eller annen rekkefølge (rekursivt eller iterativt)
            // ...og sørge for at samtlige pekere og nodeverider i treet blir nullet
            // ...aka. ikke tillstrekkelig å sette "rot" til "null" og "antall" til "0"
            // ... se eksempel i doc

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {

        // Tatt i bruk kode fra komendium av Ulf Utterud; Programkode 5.1.7 h)

        while (true) {

            // Hvis "p" sin venstre node ikke er lik null --> settes "p" lik "p" sin venstre node
            if (p.venstre != null) {
                p = p.venstre;
            }

            // Hvis "p" sin høyre node ikke er lik null --> settes "p" lik "p" sin høyre node
            else if (p.høyre != null) {
                p = p.høyre;
            }

            // Ellers returneres bare "p" sin verdi som rot
            else {
                return p;
            }
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {

        // Hvis "p" sin forelder ikke er lik null --> sjekker vi videre om foreldres noder er lik "p"
        if (p.forelder != null) {

            // Hvis "p" sin forelders høyre node er lik "p" eller lik "null" --> returneres "p" sin forelders node
            if (p.forelder.høyre == p || p.forelder.høyre == null) {
                return p.forelder;
            }

            // Hvis "p" sin forelders venstre node er lik "p" --> returneres førstePostordens forelders høyre node
            else if (p.forelder.venstre == p) {
                return førstePostorden(p.forelder.høyre);
            }
        }
        // Hvis "p" er den siste i postorden --> returneres null
        return null;
    }

    public void postorden(Oppgave<? super T> oppgave) {

        // Setter "p" lik roten av førstePostorden, aka. den første noden
        Node<T> p = førstePostorden(rot);

        // Bruker oppgaves utførOppgave av "p" sin verdi
        oppgave.utførOppgave(p.verdi);

        // Så lenge "p" sin forelder ikke er lik "null" --> sett "p" lik nestePostorden av "p"
        while (p.forelder != null) {
            p = nestePostorden(p);
            oppgave.utførOppgave(p.verdi);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {

        // Hvis "p" sin forelder er lik "null" --> brukes postordenRecursive med førstePostorden
        if (p.forelder == null){
            postordenRecursive(førstePostorden(p), oppgave);
        }

        // Hvis "p" ikke er lik "nul" --> brukes oppgaves utførOppgave av "p" sin verdi
        else {
            oppgave.utførOppgave(p.verdi);

            // Hvis nestePostorden av "p" ikke er lik rot --> brukes postordenRecursive med nestePostorden
            if (nestePostorden(p) != rot) {
                postordenRecursive(nestePostorden(p), oppgave);
            }

            // Hvis nestePostorden av "p" er lik rot --> brukes oppgaves utførOppgave av rotens verdi
            else {
                oppgave.utførOppgave(rot.verdi);
            }
        }
    }

    public ArrayList<T> serialize() {

        // Oppretter arraylisten "ut" og arraydequen "queue"
        ArrayList<T> ut = new ArrayList<>();
        ArrayDeque<Node<T>> queue = new ArrayDeque<>();

        // Legger til rot-noden
        queue.addFirst(rot);

        // Så lenge "queue" ikke er tom
        while (!queue.isEmpty()){

            // Setter "p" lik "queue" sin removeFirst(), og fjerner første node
            Node<T> p = queue.removeFirst();

            // Hvis "p" sin høyre node ikke er lik "null" --> legges "p" sin høyre node til "queue"
            if (p.høyre != null) {
                queue.addLast(p.høyre);
            }

            // Hvis "p" sin venstre node ikke er lik "null" --> legges "p" sin venstre node til "queue"
            else if (p.venstre != null) {
                queue.addLast(p.venstre);
            }

            // Legger til "p" sin verdi
            ut.add(p.verdi);
        }

        // Returnerer "ut"
        return ut;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        // Op5
        // Deserialisere: Lage et nytt tre ut ifra et array

        // Skal ta det nye arrayet og legge inn alle veridene (OBS! i nivå order), og gjenskape treet

        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
