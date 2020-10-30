# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Jeg har brukt git til å dokumentere arbeidet. Jeg har 18 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: Løst ved bruk av angittkode fra kompendiet av Ulf Utterud; Programkode 5.2.3 a). La til endring slik at noden fikk en foreldre peker. Ganske enkel og rett fra oppgave, som ikke tok noe spesielt lang tid å løse.
* Oppgave 2: Løst ved bruk av en _while-løkke_ som jobbet seg gjennom treet ved hjelp av _if-setninger_ for større, mindre eller lik verdi. Hvis noden var lik en verdi økes «count». Denne oppgaven var også relativt rett fram, med unntak av at jeg tullet litt med rekkefølgen jeg gikk gjennom treet i første runde. 
* Oppgave 3: Løste første del «førstePostorden» ved hjelp av kode fra kompendiet av Ulf Utterud; Programkode 5.1.7 h). Løste andre del «nestePostorden» ved bruk av _if-setninger_ noe likt koden i «førstePostorden» for å sjekk om noden sin forelder var lik null, lik sin høyre node eller «null» eller lik sin venstre node. Den siste delen tok litt tid, og den gir mening når jeg tegner den opp for meg selv, men jeg stusser fortsatt litt på den. 
* Oppgave 4: Løste første del «postorden» ved å sette node lik roten av «førstePostorden», altså den første noden. Brukte deretter en _while-løkke_ som jobbet seg gjennom så lenge noden sin forelder ikke var null og satt noden lik «nestePostorden» av noden. Løste andre del «postordenRecursive» gjennom å traverserer treet i postorden rekkefølge ved hjelp av if-setninger for om noden sin forelder var lik null, og om den ikke var lik null også om den var lik roten.
* Oppgave 5: Løste første del «serialize» ved å først opprette en ny arrayliste og en ny arraydequen, samt lege til rot-noden. Tok deretter i bruk _while-løkke_ som jobbet seg igjennom så lenge den nye arraydequen ikke var tom ved hjelp av _if-setninger_ for om noen sin venstre eller høyre node ikke var lik null, og la til relevant node i de ulike tilfellene. Returnerte til slutt arraylisten. Løste andre del «deserialize» ved å opprette et nytt tre. Tok deretter i bruk en enkel _for-løkke_ som la inn alle verdiene i nivå orden, og dermed gjenskapte treet. Returnerte til slutt treet igjen.
* Oppgave 6: Løste første del «fjern» ved bruk av angittkode fra kompendiet av Ulf Utterud; Programkode 5.2.8 d). La til endring av peker slik at forelder får korrekt verdi, samt en liten endring gjennom en liten oppdatering av "endringer". Ellers er koden lik. Løste andre del «fjernAlle»  ved å sette en integer lik «0», ved bruk av en _while-løkke_ oppdatere integeren og tilslutt returnere den. Løste tredje, og siste, del «nullstill» gjennom en enkel _while-løkke_ som jobbet seg gjennom så lenge det var noder i treet og satt noden lik roten av «førstePostorden», noden sin høyre, venstre, forelder og verdi lik null og oppdaterte antall. Satt til slutt roten likk «null».

#### **Warnings i «EksamenSBinTre.java»:**

- Non-ASCII characters in an identifier :10
- Private field 'endringer' is assigned but never accessed :35
- Method 'inneholder(T)' is never used :46
- Return value of the method is never used :84
- Non-ASCII characters in an identifier :232
- Dereference of 'p' may produce 'NullPointerException' :285
- Argument 'nestePostorden(p)' might be null :306
