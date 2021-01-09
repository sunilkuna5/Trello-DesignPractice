package trello.Entities;

import trello.Entities.util.IDGenerator;
import trello.Entities.util.IDGeneratorImpl;

public class User {
    String id;
    String name;
    String email;

    private static final IDGenerator idGenerator = new IDGeneratorImpl();

    public User(String name) {
        this.id = "user"+idGenerator.getId();
        this.name = name;
    }

    public User(String name, String email) {
        this(name);
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
