package javapro.dz22;

public class Lesson {
    private int id;
    private String name;
    private Homework homework;

    public Lesson(int id, String name, Homework homework) {
        this.id = id;
        this.name = name;
        this.homework = homework;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Homework getHomework() {
        return homework;
    }
}

