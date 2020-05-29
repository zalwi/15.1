import data.Item;
import logic.ItemsOperator;
import logic.ReportCreator;
import logic.SoldItemsReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> soldItems = SoldItemsReader.readDataFromFile("data.csv");
        System.out.println(soldItems);
        String reportFileName = "report.txt";
        String reportContext = ItemsOperator.generateReport(soldItems);
        ReportCreator.saveReport(reportFileName, reportContext);
        System.out.println(reportContext + "\nZapisano w " + reportFileName);
    }
}
