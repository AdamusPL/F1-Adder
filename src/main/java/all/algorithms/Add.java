package all.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import all.model.Link;

public class Add {
    public ArrayList<Link> add(String filename) {
        ArrayList<Link> links = new ArrayList<>();
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while((line=br.readLine())!=null){
//                System.out.println(line);
                String[] data = line.split("/");
                Link link = new Link(data[8],line);
                links.add(link);
            }

            br.close();
        }
        catch (FileNotFoundException ex){
//            System.out.println("Nie mozna bylo odczytac pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return links;
    }

}
