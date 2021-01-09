package trello.Entities.util;

public class IDGeneratorImpl implements IDGenerator {
    public int count = 0;

    @Override
    public String getId() {
        return count+++"";
    }
}
