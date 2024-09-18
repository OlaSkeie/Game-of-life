public class Verden {
    int genNr; 
    int antLevendeNaboer;
    int rader;
    int kolonner;
    Rutenett rutenett;
    public Verden(int rader, int kolonner){
        this.rutenett = new Rutenett(rader, kolonner);
        genNr = 0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        this.rader = rader;
        this.kolonner = kolonner;
        
    }
    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjonsnummer:" + genNr + " Antall levende: " + rutenett.antallLevende());
       
    }
    public void oppdatering(){
        tegn();
       
        for(int i = 0; i < rader; i ++){
            
            for(int u = 0; u < kolonner; u ++){
                
                rutenett.hentCelle(i,u).tellLevendeNaboer();
                
 
            
                }
            }
            for(int i = 0; i < rader; i ++){
                for(int u = 0; u < kolonner; u ++){
                    
                
                rutenett.hentCelle(i,u).oppdaterStatus();
            
        
                }
            }
    
        genNr ++;
}  
}
