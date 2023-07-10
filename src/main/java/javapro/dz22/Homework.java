package javapro.dz22;

public class Homework {
    private int id;
    private String name;
    private String description;

    public Homework(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
