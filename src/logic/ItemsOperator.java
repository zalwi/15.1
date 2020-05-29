package logic;

import data.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class ItemsOperator {

    private final static String CURRENCY = "zł";

    private ItemsOperator(){};

    public static String generateReport(List<Item> items){
        BigDecimal sumOfNettoPrices     = new BigDecimal("0");
        BigDecimal sumOfVat             = new BigDecimal("0");
        BigDecimal sumOfBruttoPrices    = new BigDecimal("0");

        for(Item item: items){
            BigDecimal itemNettoPrice   = new BigDecimal(item.getPrice());
            BigDecimal itemVat          = (new BigDecimal(
                                            item.getVat())).divide(new BigDecimal("100"), new MathContext(2));
            BigDecimal itemVatValue     = itemNettoPrice.multiply(itemVat);
            BigDecimal itemBruttoPrice  = itemNettoPrice.add(itemVatValue);

            sumOfNettoPrices    = sumOfNettoPrices.add(itemNettoPrice);
            sumOfVat            = sumOfVat.add(itemVatValue);
            sumOfBruttoPrices   = sumOfBruttoPrices.add(itemBruttoPrice);
        }
        String context =    "Sprzedaż Netto:\t"+ sumOfNettoPrices + CURRENCY +"\n" +
                            "Suma podatku VAT ze sprzedaży:\t"+ sumOfVat + CURRENCY +"\n" +
                            "Suma sprzedaży Brutto:\t"+ sumOfBruttoPrices + CURRENCY;
        return context;
    }
}
