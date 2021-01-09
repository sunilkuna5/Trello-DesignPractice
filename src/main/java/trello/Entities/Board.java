package trello.Entities;

import trello.Entities.util.IDGenerator;
import trello.Entities.util.IDGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private String id;
    private String name;
    private String url;
    private PrivacyType privacyType;
    private List<User> members;
    private List<TrelloList> lists;
    private final static IDGenerator idGenerator = new IDGeneratorImpl();

    public Board(String name) {
        id = idGenerator.getId();
        this.name = name;
        this.url = id;
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
        this.privacyType = PrivacyType.PUBLIC;
    }

    public PrivacyType getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(PrivacyType privacyType) {
        this.privacyType = privacyType;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<TrelloList> getLists() {
        return lists;
    }

    public void setLists(List<TrelloList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", privacyType=" + privacyType +
                ", members=" + members +
                ", lists=" + lists +
                '}';
    }
}
