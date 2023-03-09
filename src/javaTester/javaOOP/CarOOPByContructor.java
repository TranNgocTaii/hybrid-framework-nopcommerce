package javaTester.javaOOP;

public class CarOOPByContructor {
    // thuoc tinh
    private String carCompany;
    private String carType;
    private String fuelType;
    private Float mileAge;
    private Double carPrice;

    public CarOOPByContructor(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
        this.carCompany = carCompany;
        this.carType = carType;
        this.fuelType = fuelType;
        this.mileAge = mileAge;
        this.carPrice = carPrice;
    }



    public static void main (String[] args) {
        // Honda
        CarOOPByContructor honda = new CarOOPByContructor("Honda","City","Petrol",150f,50000d);
        CarOOPByContructor toyota = new CarOOPByContructor("Toyota","Camry","Diesel",200f,60000d);

    }
}
