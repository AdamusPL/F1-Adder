package all.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import all.model.Link;

public class LinksHandler {
    public ArrayList<Link> add(String filename) {
        ArrayList<Link> links = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                String[] data = line.split("/");
                Link link = new Link(data[8], line);
                links.add(link);
            }

            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open up file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return links;
    }

}
