package trello.Entities;

import trello.Entities.util.IDGenerator;
import trello.Entities.util.IDGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class TrelloList {
    private String id;
    private String name;
    private List<Card> cards;
    private final static IDGenerator idGenerator = new IDGeneratorImpl();

    public TrelloList(String name) {
        id = idGenerator.getId();
        this.name = name;
        this.cards = new ArrayList<>();
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                "}";
    }
}
