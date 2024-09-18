public class Timer implements Runnable {
    Kontroll kontroll;

    public Timer(Kontroll kontroll){
        this.kontroll = kontroll;
    }
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(2000);
                kontroll.oppdater();
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            
        }

    }
    
}
