package ua.khpi.oop.lab05;

public class PublicBuilding extends Building {
    private final int visitorCapacity;

    public PublicBuilding(String address, int yearBuilt, int visitorCapacity) {
        super(address, yearBuilt);
        this.visitorCapacity = visitorCapacity;
    }

    public int getVisitorCapacity() {
        return visitorCapacity;
    }

    @Override
    public String description() {
        return super.description() + ", visitorCapacity=" + visitorCapacity;
    }
}