package ch.unil.doplab.currencyconverter;

import java.util.HashMap;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class CurrencyList {

    private static CurrencyList singletonInstance = null;
    private HashMap<String, HashMap<String, Double>> currencyList;

    private CurrencyList() {
        initializeCurrencyList();
    }

    public static CurrencyList getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new CurrencyList();
        }
        return singletonInstance;
    }

    /**
     * Currency List
     *
     * FROM\TO | CHF | USD | EURO | --------|------|------|------| CHF | 1.00 |
     * 1.12 | 0.93 | USD | 0.89 | 1.00 | 0.83 | EURO | 1.08 | 1.21 | 1.00 |
     */
    private void initializeCurrencyList() {
        currencyList = new HashMap<String, HashMap<String, Double>>();
        // from CHF row
        HashMap<String, Double> fromCHF = new HashMap<String, Double>();
        fromCHF.put("CHF", 1.00);
        fromCHF.put("USD", 1.12);
        fromCHF.put("EURO", 0.93);
        currencyList.put("CHF", fromCHF);
        // from USD row
        HashMap<String, Double> fromUSD = new HashMap<String, Double>();
        fromUSD.put("CHF", 0.89);
        fromUSD.put("USD", 1.00);
        fromUSD.put("EURO", 0.83);
        currencyList.put("USD", fromUSD);
        // from EURO row
        HashMap<String, Double> fromEURO = new HashMap<String, Double>();
        fromEURO.put("CHF", 1.08);
        fromEURO.put("USD", 1.21);
        fromEURO.put("EURO", 1.00);
        currencyList.put("USD", fromEURO);
    }

    public HashMap<String, HashMap<String, Double>> getCurrencyList() {
        return currencyList;
    }

}
