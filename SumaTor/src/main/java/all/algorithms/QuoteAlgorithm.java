package all.algorithms;

import all.model.Quote;

import java.util.ArrayList;
import java.util.Random;

public class QuoteAlgorithm {

    public Quote chooseRandomQuote(){
        Download download = new Download();
        ArrayList<Quote> quoteArrayList = download.downloadQuotes(); //download list of quotes

        Quote randomQuote;

        Random randomizer = new Random();
        randomQuote = quoteArrayList.get(randomizer.nextInt(quoteArrayList.size()));

        return randomQuote;
    }

}
