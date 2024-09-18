

public class Rutenett {
    int antKolonner; // Hadde gjort disse private, men da kjører ikke testprogrammet
    int antRader;
    Celle[][] rutene;
    public Rutenett(int antRader, int antKolonner){
        this.antKolonner = antKolonner;
        this.antRader = antRader;
        this.rutene = new Celle[antRader][antKolonner];

    }
    public void lagCelle(int rad, int kolonne){
        Celle celle = new Celle();
        rutene[rad][kolonne] = celle;
        if(Math.random()< 0.333){
            celle.settLevende();
        }
        else{
            celle.settDoed();
        }
    }
   
    public void fyllMedTilfeldigeCeller(){
        for(int i = 0; i < rutene.length; i++){
            for(int o = 0; o < rutene[i].length; o++){ 
                lagCelle(i,o);
            }
    }
}
    public Celle hentCelle(int rad, int kolonne){
        if(rad >= 0 && kolonne >= 0){
            if(rad < antRader && kolonne < antKolonner){
                return rutene[rad][kolonne];
            }
        }
        return null;
    }
    public void tegnRutenett(){
        for(int i = 0; i < rutene.length; i++){
            for(int o = 0; o < rutene[i].length; o++){
                
                System.out.print(rutene[i][o].hentStatusTegn());
               
            }
            System.out.println();
        }
    }
    public void settNaboer(int rad, int kolonne){
        int[] tall = {-1, 1};
        Celle celle = rutene[rad][kolonne];
        for(int i : tall){
            if(hentCelle(rad + i, kolonne) != null){
                celle.leggTilNabo(hentCelle(rad + i, kolonne) );; 
            }
            if(hentCelle(rad, kolonne + i) != null){
                celle.leggTilNabo(hentCelle(rad , kolonne + i) );;
            }
            if(hentCelle(rad + i, kolonne + i) != null){
                celle.leggTilNabo(hentCelle(rad + i, kolonne + i) );;
            }
            if(hentCelle(rad - i, kolonne + i) != null){
                celle.leggTilNabo(hentCelle(rad - i, kolonne + i) );;
            }

            
        }
        
    }
    public void kobleAlleCeller(){
        for(int i = 0; i < rutene.length; i++){
            for(int o = 0; o < rutene[i].length; o++){
                settNaboer(i, o);
            }
        }

            }
    public int antallLevende(){
        int antLev = 0;
        for(int i = 0; i < rutene.length; i++){
            for(int o = 0; o < rutene[i].length; o++){
                if(rutene[i][o].erLevende() == true){
                    antLev ++;
                }
            }
        }
        return antLev;
        }}
    
