package ua.khpi.oop.lab09.model;

public class MedicalRecord<TEntity, TMeta> {
    private final TEntity entity;
    private final TMeta metadata;

    public MedicalRecord(TEntity entity, TMeta metadata) {
        if (entity == null) {
            throw new IllegalArgumentException("Основний об'єкт запису не може бути null");
        }
        if (metadata == null) {
            throw new IllegalArgumentException("Метадані запису не можуть бути null");
        }

        this.entity = entity;
        this.metadata = metadata;
    }

    public TEntity getEntity() {
        return entity;
    }

    public TMeta getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "Медичний запис {" +
                "об'єкт = " + entity +
                ", метадані = " + metadata +
                '}';
    }
}