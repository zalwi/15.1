package logic;

import data.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoldItemsReader {

    private SoldItemsReader(){
    }

    public static List<Item> readDataFromFile(String fileName){
        List<Item> items = new ArrayList<Item>();
        try(
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ){
            String nextLine     = null;
            while ((nextLine = reader.readLine()) != null) {
                String [] lineValues = nextLine.split(";");
                String name     = lineValues[0];
                String price    = lineValues[1];
                String vat      = lineValues[2];
                items.add(new Item(name,price,vat));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return items;
    }
}
