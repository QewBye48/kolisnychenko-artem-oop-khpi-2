package ua.khpi.oop.lab05;

public class MedicalBuilding extends PublicBuilding {
    private final int doctorsCount;

    public MedicalBuilding(String address, int yearBuilt, int visitorCapacity, int doctorsCount) {
        super(address, yearBuilt, visitorCapacity);
        this.doctorsCount = doctorsCount;
    }

    public int getDoctorsCount() {
        return doctorsCount;
    }

    @Override
    public String description() {
        return super.description() + ", doctorsCount=" + doctorsCount;
    }
}