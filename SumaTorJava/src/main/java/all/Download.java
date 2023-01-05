package all;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Download {

    public ArrayList<Quote> downloadQuotes(){ //metoda robiąca arraylistę powiedzonek
        ArrayList<Quote> quoteArrayList = new ArrayList<>();
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            line=br.readLine();

            while((line=br.readLine())!=null){
                String[] data=line.split("; ");
                Quote quote = new Quote(data[0]);
                quoteArrayList.add(quote);
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Nie mozna bylo odczytac pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quoteArrayList;
    }

    public ArrayList<Participant> downloadParticipants(){ //metoda robiąca arraylistę uczestników
        ArrayList<Participant> participantArrayList=new ArrayList<>();
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("2022.txt"));
            line=br.readLine();

            while((line=br.readLine())!=null){
                String[] data=line.split("; ");
                JTextField pointsField = new JTextField();
                JTextField jokersField = new JTextField();
                Participant participant = new Participant(data[0],Double.parseDouble(data[1]),Integer.parseInt(data[2]),pointsField,jokersField);
                participantArrayList.add(participant);
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Nie mozna bylo odczytac pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return participantArrayList;
    }

}
