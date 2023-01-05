package all;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {
    ArrayList<Participant> participantArrayList;
    JButton button;
    JTextField pointsField;
    JTextField jokersField;
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
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
        participantArrayList = download.downloadParticipants();

        JPanel standings = new JPanel();
        standings.setBounds(5,300,quoteWidth,250);
        standings.setLayout(null);

        int x=5, y=5;

        int numberOfAttributes = Participant.class.getDeclaredFields().length;
        ArrayList<String> attributes = new ArrayList<>(numberOfAttributes);
        attributes.add("Imie");
        attributes.add("Liczba zdobytych punktow");
        attributes.add("Liczba uzytych Jokerow"); //tutaj zrobić uzależnienie od ilości atrybutów, bo tak to kiepsko


        for(String a: attributes){
            JLabel columnLabel = new JLabel();
            columnLabel.setText(a);
            columnLabel.setBounds(x,y,350,20);
            standings.add(columnLabel);
            for (Participant p: participantArrayList) {
                y+=25;
                JLabel participantLabel = new JLabel();
                if(a.equals("Imie")) participantLabel.setText(p.name);
                else if(a.equals("Liczba zdobytych punktow")){
                    participantLabel.setText(Double.toString(p.points));
                    p.pointsField.setBounds(a.length()*9,y,25,25);
                    standings.add(p.pointsField);
                    button=new JButton("OK!");
                    button.setBounds(a.length()*10,y,60,25);
                    standings.add(button);
                }
                else if(a.equals("Liczba uzytych Jokerow")){
                    participantLabel.setText(Integer.toString(p.numberOfUsedJokers));
                    p.jokersField.setBounds(a.length()*21,y,25,25);
                    standings.add(p.jokersField);
                    button=new JButton("OK!");
                    button.setBounds(a.length()*22,y,60,25);
                    standings.add(button);
                }
                participantLabel.setBounds(x,y,500,20);
                standings.add(participantLabel);
            }
            y=5;
            x+=a.length()*10;
            x+=20;
        }


        this.add(welcomeLabel);
        this.add(imageLabel);
        this.add(quoteLabel);
        this.add(standings);
        this.setVisible(true);


        this.getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            try{
                PrintWriter writer = new PrintWriter("2022.txt");
                writer.println("Imię; Liczba punktów; Liczba użytych Jokerów");
                for (Participant p: participantArrayList) {
                    writer.println(p.name+"; "+ pointsField.getText()+"; "+ jokersField.getText());
                }
                writer.close();
            }
            catch (FileNotFoundException ex){
                System.out.println("Nie mozna bylo odczytac pliku");
            }

        }
    }

    public boolean isDoubleNumber(JTextField input){
        try{
            Double.parseDouble(input.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isIntNumber(JTextField input){
        try{
            Integer.parseInt(input.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
