package ua.khpi.oop.lab05;

public class EducationalBuilding extends PublicBuilding {
    private final int classroomsCount;

    public EducationalBuilding(String address, int yearBuilt, int visitorCapacity, int classroomsCount) {
        super(address, yearBuilt, visitorCapacity);
        this.classroomsCount = classroomsCount;
    }

    public int getClassroomsCount() {
        return classroomsCount;
    }

    @Override
    public String description() {
        return super.description() + ", classroomsCount=" + classroomsCount;
    }
}