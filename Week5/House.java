public class House {
    // Data properties
    private int numberOfBedrooms;
    private String color;
    
    // Constructor
    public House(int numberOfBedrooms, String color) {
        this.numberOfBedrooms = numberOfBedrooms;
        this.color = color;
    }
    
    // Getter methods
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }
    
    public String getColor() {
        return color;
    }
    
    // Setter methods
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    // Method to get house information
    public String getInfo() {
        return "This house has " + numberOfBedrooms + " bedrooms and is " + color + " in color.";
    }
    
    // toString method
    @Override
    public String toString() {
        return "House{bedrooms=" + numberOfBedrooms + ", color='" + color + "'}";
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create house instances
        House myHouse = new House(3, "blue");
        House anotherHouse = new House(2, "red");
        
        // Print house information
        System.out.println(myHouse.getInfo());
        System.out.println(myHouse);
        
        System.out.println(anotherHouse.getInfo());
        System.out.println(anotherHouse);
    }
}
