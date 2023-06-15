public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
}
