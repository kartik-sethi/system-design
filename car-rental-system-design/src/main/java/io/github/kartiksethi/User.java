package io.github.kartiksethi;

public class User {
    private final int id;
    private final String name;
    private final String license;

    public User(int id, String name, String license) {
        this.id = id;
        this.name = name;
        this.license = license;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }
}
