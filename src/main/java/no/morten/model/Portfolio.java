package no.morten.model;

/**
 * Created by mortens on 21.12.2016.
 */
public class Portfolio {
    private String ticker;
    private Integer numberOfShares;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

}

