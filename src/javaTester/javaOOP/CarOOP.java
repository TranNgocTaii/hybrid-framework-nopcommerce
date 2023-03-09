package javaTester.javaOOP;

public class CarOOP {
    // thuoc tinh
    private String carCompany;
    private String carType;
    private String fuelType;
    private Float mileAge;
    private Double carPrice;

    protected String getCarCompany() {
        return carCompany;
    }

    protected void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    protected String getCarType() {
        return carType;
    }

    protected void setCarType(String carType) {
        this.carType = carType;
    }

    protected String getFuelType() {
        return fuelType;
    }

    protected void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    protected Float getMileAge() {
        return mileAge;
    }

    protected void setMileAge(Float mileAge) {
        this.mileAge = mileAge;
    }

    protected Double getCarPrice() {
        return carPrice;
    }

    protected void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    protected void showCarInfo(){
        System.out.println(("Car company = " + getCarCompany()));
        System.out.println(("Car carType = " + getCarType()));
        System.out.println(("Car fuelType = " + getFuelType()));
        System.out.println(("Car mileAge = " + getCarPrice()));
        System.out.println(("Car carPrice = " + getMileAge()));
    }

    public static void main (String[] args){
        // Honda
        CarOOP honda = new CarOOP();
        honda.setCarCompany("Honda");
        honda.setCarPrice(50000d);
        honda.setCarType("City");
        honda.setFuelType("Petrol");
        honda.setMileAge(150f);
        honda.showCarInfo();

        // Toyota
        CarOOP toyota = new CarOOP();
        honda.setCarCompany("Toyota");
        honda.setCarPrice(60000d);
        honda.setCarType("Camry");
        honda.setFuelType("Diesel");
        honda.setMileAge(200f);
        honda.showCarInfo();
    }
}
