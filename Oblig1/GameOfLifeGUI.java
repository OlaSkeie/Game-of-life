import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameOfLifeGUI {
    Kontroll kontroll;
    JButton start, avslutt;
    JFrame vindu;
    JButton rutenett[][];
    int rader, kolonner;
    JLabel antLevende;
    JPanel bakgrunn, en, to;

    
    class Start implements ActionListener{
        Timer timer = new Timer(kontroll);
        Thread traad = new Thread(timer);
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.oppdater();
            traad.start();
        }

    }
    class Avslutt implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.avslutt();
        }

    }
    

    class EndreCelle implements ActionListener{
        int rad, kol;
        public EndreCelle(int rad, int kol){
            this.rad = rad;
            this.kol = kol;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            kontroll.endre_celle(rad, kol);
        }
    }
   


    
    public GameOfLifeGUI(Kontroll kontroll){
        this.kontroll = kontroll;
        rader = 8;
        kolonner = 12;
        rutenett = new JButton[rader][kolonner];
        vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bakgrunn = new JPanel(new BorderLayout());
        vindu.add(bakgrunn);
        en = new JPanel(new BorderLayout());
       
        bakgrunn.add(en, BorderLayout.NORTH);
        
        antLevende = new JLabel("");
        bakgrunn.add(antLevende);
        start = new JButton("Start");
        avslutt = new JButton("Avslutt");
        start.addActionListener(new Start());
        avslutt.addActionListener(new Avslutt());
        en.add(start, BorderLayout.WEST);
        en.add(avslutt, BorderLayout.EAST);
        en.add(antLevende, BorderLayout.CENTER);
        to = new JPanel();
        to.setLayout(new GridLayout(rader, kolonner));
        bakgrunn.add(to, BorderLayout.CENTER);
        for(int r = 0; r < rader; r++){
            for(int k = 0; k < kolonner; k++){
                JButton celle = new JButton("");
                rutenett[r][k] = celle;
                celle.addActionListener(new EndreCelle(r, k));
                to.add(celle);
            }
        }
        settCelle();
        oppdater_levende();
        vindu.pack();
        vindu.setSize(800,500);
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
        


    }
    public void settCelle(){
        for(int r = 0; r < 8; r++){
            for(int k = 0; k < 12; k++){
                if(kontroll.verden.rutenett.hentCelle(r, k).erLevende()){
                    rutenett[r][k].setText("*");
                }
                else{
                    rutenett[r][k].setText("");
                }
            }
        }
        vindu.repaint();
    }
    public void endre_celle_status(int rad, int kol){
        
        if(rutenett[rad][kol].getText().equals("")){
            rutenett[rad][kol].setText("*");
            kontroll.verden.rutenett.hentCelle(rad, kol).settLevende();

        }
        else{
            rutenett[rad][kol].setText("");
            kontroll.verden.rutenett.hentCelle(rad, kol).settDoed();
        }
        vindu.repaint();

        
    }
    
   

    public void oppdater_levende(){
        String lev = String.valueOf(kontroll.verden.rutenett.antallLevende());
        antLevende.setText("antLevende: " + lev);
        
       }
    }