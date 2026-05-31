package ua.khpi.oop.lab05;

public final class UniversityCampusBuilding extends EducationalBuilding {
    private final String facultyName;

    public UniversityCampusBuilding(String address, int yearBuilt, int visitorCapacity,
                                    int classroomsCount, String facultyName) {
        super(address, yearBuilt, visitorCapacity, classroomsCount);
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String description() {
        return super.description() + ", facultyName=" + facultyName;
    }
}