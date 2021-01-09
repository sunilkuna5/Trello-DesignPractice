package trello.Entities;

import trello.Entities.util.IDGenerator;
import trello.Entities.util.IDGeneratorImpl;

public class Card {
    private String id;
    private String name;
    private String description;
    private User user;
    private final static IDGenerator idGenerator = new IDGeneratorImpl();

    public Card(String name) {
        id = idGenerator.getId();
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
