package all.algorithms;

import all.model.Quote;

import java.util.ArrayList;
import java.util.Random;

public class QuoteAlgorithm {

    public Quote chooseRandomQuote(){
        Download download = new Download();
        ArrayList<Quote> quoteArrayList = download.downloadQuotes(); //pobierz listę powiedzonek

        Quote randomQuote;

        Random randomizer = new Random();
        randomQuote = quoteArrayList.get(randomizer.nextInt(quoteArrayList.size()));

        return randomQuote;
    }

}
