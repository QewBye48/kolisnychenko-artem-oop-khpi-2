package ua.khpi.oop.lab05;

public class Building {
    private final String address;
    private final int yearBuilt;

    public Building(String address, int yearBuilt) {
        this.address = address;
        this.yearBuilt = yearBuilt;
    }

    public String getAddress() {
        return address;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public String description() {
        return "Building [address=" + address + ", yearBuilt=" + yearBuilt + "]";
    }
}