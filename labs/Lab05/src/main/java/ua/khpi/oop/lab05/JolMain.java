package ua.khpi.oop.lab05;

import org.openjdk.jol.info.ClassLayout;

public class JolMain {
    public static void main(String[] args) {
        UniversityCampusBuilding building = new UniversityCampusBuilding(
                "Kharkiv, Kyrpychova St. 2",
                1965,
                500,
                25,
                "Computer Science"
        );

        System.out.println(ClassLayout.parseInstance(building).toPrintable());
    }
}