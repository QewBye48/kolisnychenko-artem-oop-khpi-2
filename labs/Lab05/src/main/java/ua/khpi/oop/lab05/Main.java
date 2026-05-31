package ua.khpi.oop.lab05;

public class Main {
    public static void main(String[] args) {
        Building building = new Building("Харків, проспект Науки, 10", 1980);

        PublicBuilding publicBuilding =
                new PublicBuilding("Харків, вулиця Сумська, 20", 1995, 300);

        EducationalBuilding educationalBuilding =
                new EducationalBuilding("Харків, вулиця Кирпичова, 2", 1965, 500, 25);

        UniversityCampusBuilding universityBuilding =
                new UniversityCampusBuilding("Харків, вулиця Кирпичова, 2", 1965, 500, 25, "Комп'ютерні науки");

        MedicalBuilding medicalBuilding =
                new MedicalBuilding("Харків, вулиця Пушкінська, 15", 2005, 200, 40);

        System.out.println(building.description());
        System.out.println(publicBuilding.description());
        System.out.println(educationalBuilding.description());
        System.out.println(universityBuilding.description());
        System.out.println(medicalBuilding.description());
    }
}