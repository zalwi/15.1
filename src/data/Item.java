package data;

public class Item {
    private String name;
    private String price;
    private String vat;

    public Item(String name, String price, String vat) {
        this.name = name;
        this.price = price;
        this.vat = vat;
    }

    public String getPrice() {
        return price;
    }

    public String getVat() {
        return vat;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", vat='" + vat + '\'' +
                '}';
    }
}
