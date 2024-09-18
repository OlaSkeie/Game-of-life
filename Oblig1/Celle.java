
public class Celle {
    boolean levende; // Hadde gjort disse private, men da kjører ikke testprogrammet
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle() {
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0;

    }

    public void settLevende() {
        levende = true;
    }

    public void settDoed() {
        levende = false;
    }

    public boolean erLevende() {
        if (levende == true) {
            return true;
        } else {
            return false;
        }
    }

    public char hentStatusTegn() {
        if (levende == true) {
            return 'O';
        } else {
            return '.';
        }

    }

    public void leggTilNabo(Celle nabo) {
        antNaboer++;
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] == null) {
                naboer[i] = nabo;
                break;
            }

        }

    }
   

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] != null) {
                if (naboer[i].erLevende()) {
                    antLevendeNaboer++;
                }
            }
        }
    }

    public void oppdaterStatus() {

        if (levende) {
            if (antLevendeNaboer < 2) {
                settDoed();
            }
            if (antLevendeNaboer > 3) {

                settDoed();
            }
        } else {
            if (antLevendeNaboer == 3) {

                settLevende();
            }
        }

    }

}
