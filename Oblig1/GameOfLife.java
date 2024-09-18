import java.util.Scanner;
public class GameOfLife {
    
    public static void main(String[] args){
        int rader; // Hadde gjort disse private, men da kjører ikke testprogrammet
        int kolonner;
        int valg;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hvor mange rader vil du ha? ");
        rader = scan.nextInt();
        System.out.println("Hvor mange kolonner vil du ha? ");
        kolonner = scan.nextInt();
        Verden verden = new Verden(rader, kolonner);
        verden.oppdatering();
        
        System.out.println("Skriv 1 for en ny generasjon eller 2 for å stoppe: ");
        valg = scan.nextInt();
        while(valg == 1){
            verden.oppdatering();
            
            System.out.println("Skriv 1 for en ny generasjon eller 2 for å stoppe: ");
            valg = scan.nextInt();

        }
        scan.close();
    
    }
        
    
}
