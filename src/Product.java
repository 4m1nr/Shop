import java.util.ArrayList;

public class Product {
    private final String id;
    private String name, description;
    private double price;
    private int stock;
    private ArrayList<String> images;
    private ArrayList<String> categories;

    public Product(String id, String name, String description, double price, int stock, ArrayList<String> images, ArrayList<String> categories) {
        this.id = id;
        setName(name);
        setDescription(description);
        setPrice(price);
        setStock(stock);
        this.images = images;
        this.categories = categories;
    }

    //initialize getters and setters
    //getters
    public String getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getPrice() {return price;}
    public int getStock() {return stock;}
    public ArrayList<String> getImages() {return images;}
    public ArrayList<String> getCategories() {return categories;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPrice(double price) {this.price = price;}
    public void setStock(int stock) {this.stock = stock;}

    public void addImage(String link){images.add(link);}
    public void removeImage(String link){images.remove(link);}
    public void removeImage(int index){images.remove(index);}
    public void removeAllImages(){images.clear();}

    public void addCategory(String category){categories.add(category);}
    public void removeCategory(String category){categories.remove(category);}
    public void removeCategory(int index){categories.remove(index);}
    public void removeAllCategories(){categories.clear();}
}
