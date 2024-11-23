public class Item {
    private int item_id;
    private float price;
    private int stock_quantity; 
    private String item_name;

    public Item(int item_id, String item_name, float price, int stock_quantity) {
        this.item_id = item_id;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.item_name = item_name;
    }

    public Item() {
        this.item_id = 0;
        this.price = 0.0f;
        this.stock_quantity = 0;
        this.item_name = " ";
    }

    public void reduceQty(int qty) {
        this.stock_quantity = Math.max(0, this.stock_quantity - qty);
    }

    public void increaseOty() {
        stock_quantity++;
    } 

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public float getStock_quantity() {
        return stock_quantity;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_name() {
        return item_name;
    }
}
