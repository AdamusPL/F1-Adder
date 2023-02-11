package all;

import all.algorithms.Download;
import all.model.Driver;
import all.model.Participant;
import all.model.Quote;
import all.algorithms.QuoteAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {
    ArrayList<Participant> participantArrayList;
    ArrayList<Driver> driversArrayList;
    JTextArea bets;
    public MainFrame() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        int labelHeight=20;

        /*labelka z powitaniem*/

        JLabel welcomeLabel = new JLabel("Witamy w programie do sumowania punktow F1 w sezonie 2022!");
        welcomeLabel.setBounds(5, 5, 400, labelHeight);

        /*logo programu*/
        JLabel imageLabel = new JLabel(); //JLabel Creation
        imageLabel.setIcon(new ImageIcon("logo.png")); //Sets the image to be displayed as an icon
        Dimension size = imageLabel.getPreferredSize(); //Gets the size of the image
        imageLabel.setBounds(5, 5, size.width, size.height); //Sets the location of the image


        /*losowe powiedzonko*/
        int quoteWidth=700;

        QuoteAlgorithm quoteAlgorithm = new QuoteAlgorithm();
        Quote randomQuote = quoteAlgorithm.chooseRandomQuote(); //wybranie losowego powiedzonka z bazy danych

        JLabel quoteLabel = new JLabel();
        quoteLabel.setText("Quote na dzisiaj: "+randomQuote.textOfQuote);
        quoteLabel.setBounds(5,size.height-5,quoteWidth,50);

        /*wypisywanie wyników*/
        //zrobić tyle JPaneli, JTextFieldów i JLabelów ile jest osób w lidze
        Download download = new Download();
        driversArrayList=download.downloadScores();
        participantArrayList = download.downloadParticipants();

        JPanel standings = new JPanel();
        standings.setBounds(5,300,quoteWidth,350);
        standings.setLayout(null);

        int numberOfAttributes = Participant.class.getDeclaredFields().length;
        ArrayList<String> attributes = new ArrayList<>(numberOfAttributes);
        attributes.add("Imie");
        attributes.add("Liczba zdobytych punktow");
        attributes.add("Liczba uzytych Jokerow"); //tutaj zrobić uzależnienie od ilości atrybutów, bo tak to kiepsko

        //trzy panele, na każdą kolumnę, zacząłem, ale się pierdoli
        int x=5, y=5;
        for(String a: attributes){
            JPanel panel = new JPanel();
            panel.setBounds(x,y,200,150);
            panel.setLayout(null);
            JLabel columnLabel = new JLabel();
            columnLabel.setText(a);
            columnLabel.setBounds(0,0,300,20);
            panel.add(columnLabel);
            int i=0;
            for (Participant p: participantArrayList) {
                y+=25;
                JLabel participantLabel = new JLabel();
                if(a.equals("Imie")) participantLabel.setText(p.getName());
                else if(a.equals("Liczba zdobytych punktow")){
                    participantLabel.setText(Double.toString(p.getPoints()));
                }
                else if(a.equals("Liczba uzytych Jokerow")){
                    participantLabel.setText(Integer.toString(p.getNumberOfUsedJokers()));
                }
                participantLabel.setBounds(0,y,500,20);
                panel.add(participantLabel);
                standings.add(panel);
                i++;
            }
            y=5;
            x+=210;
        }

        JLabel hereWrite = new JLabel("Tu wpisz bety zawodnika:");
        hereWrite.setBounds(300,150,200,50);
        standings.add(hereWrite);

        bets = new JTextArea();
        bets.setBounds(300,200,150,100);
        standings.add(bets);

        this.add(welcomeLabel);
        this.add(imageLabel);
        this.add(quoteLabel);
        this.add(standings);
        this.setVisible(true);

        this.getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
