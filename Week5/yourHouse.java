import java.util.ArrayList;
import java.util.List;

public class yourHouse {
    // Data properties
    private int numberOfBathroom;
    private int kitchen;
    private String color;
    private List<String> furniture;
    
    // Constructor
    public yourHouse(int numberOfBathroom, int kitchen, String color) {
        this.numberOfBathroom = numberOfBathroom;
        this.kitchen = kitchen;
        this.color = color;
        this.furniture = new ArrayList<>();
    }
    
    // Getter methods
    public int getNumberOfBathroom() {
        return numberOfBathroom;
    }
    
    public int getKitchen() {
        return kitchen;
    }
    
    public String getColor() {
        return color;
    }
    
    public List<String> getFurniture() {
        return furniture;
    }
    
    // Setter methods
    public void setNumberOfBathroom(int numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }
    
    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    // Methods for furniture management
    public void addFurniture(String furnitureItem) {
        this.furniture.add(furnitureItem);
    }
    
    public void removeFurniture(String furnitureItem) {
        this.furniture.remove(furnitureItem);
    }
    
    public void clearFurniture() {
        this.furniture.clear();
    }
    
    // Method to get house information
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("This house has ").append(numberOfBathroom).append(" bathrooms, ");
        info.append(kitchen).append(" kitchen(s), and is ").append(color).append(" in color.");
        
        if (!furniture.isEmpty()) {
            info.append("\nFurniture includes: ");
            info.append(String.join(", ", furniture));
        } else {
            info.append("\nNo furniture listed yet.");
        }
        
        return info.toString();
    }
    
    // Method to list all furniture
    public String getFurnitureList() {
        if (furniture.isEmpty()) {
            return "No furniture in this house.";
        }
        return "Furniture: " + String.join(", ", furniture);
    }
    
    // toString method
    @Override
    public String toString() {
        return "yourHouse{bathrooms=" + numberOfBathroom + 
               ", kitchens=" + kitchen + 
               ", color='" + color + "'" + 
               ", furniture=" + furniture + "}";
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create house instance
        yourHouse myHouse = new yourHouse(2, 1, "white");
        
        // Add some furniture
        myHouse.addFurniture("Sofa");
        myHouse.addFurniture("Dining Table");
        myHouse.addFurniture("Bed");
        myHouse.addFurniture("Wardrobe");
        myHouse.addFurniture("TV");
        
        // Print house information
        System.out.println(myHouse.getInfo());
        System.out.println("\n" + myHouse);
        
        // Create another house
        yourHouse anotherHouse = new yourHouse(1, 1, "brown");
        anotherHouse.addFurniture("Coffee Table");
        anotherHouse.addFurniture("Bookshelf");
        
        System.out.println("\n" + anotherHouse.getInfo());
    }
}
