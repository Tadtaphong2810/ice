public class item {
    // Data property - private float price
    private float price;
    
    // Constructor - public Item() that sets price to 0
    public item() {
        this.price = 0;
    }
    
    // Method - public getPrice() that returns price
    public float getPrice() {
        return price;
    }
    
    // Method - public setPrice(float p) that updates price
    public void setPrice(float p) {
        this.price = p;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create item object
        item myItem = new item();
        
        // Test initial price
        System.out.println("Initial price: " + myItem.getPrice());
        
        // Set new price
        myItem.setPrice(99.99f);
        System.out.println("Price after setPrice(99.99f): " + myItem.getPrice());
        
        // Set another price
        myItem.setPrice(150.50f);
        System.out.println("Price after setPrice(150.50f): " + myItem.getPrice());
    }
}
