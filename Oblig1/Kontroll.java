class Kontroll {
int rader, kolonner;
Verden verden;
GameOfLifeGUI gameOfLife;
    public Kontroll(){
        rader = 8;
        kolonner = 12;
        verden = new Verden(rader, kolonner);
        gameOfLife = new GameOfLifeGUI(this);
    }
    public void oppdater(){
        verden.oppdatering();
        gameOfLife.settCelle();
        gameOfLife.oppdater_levende();

    }
    public void settCelleTegn(){
        gameOfLife.settCelle();
    }
    public void avslutt(){
        System.exit(0);
    }
    public void celle(int rad, int kol){
        if(verden.rutenett.hentCelle(rad, kol).erLevende()){
            verden.rutenett.hentCelle(rad, kol).settDoed();
        }
        else{
            verden.rutenett.hentCelle(rad, kol).settLevende();
        }
    }
    public void endre_celle(int rad, int kol){
        gameOfLife.endre_celle_status(rad, kol);
        gameOfLife.oppdater_levende();
    }
    
}
