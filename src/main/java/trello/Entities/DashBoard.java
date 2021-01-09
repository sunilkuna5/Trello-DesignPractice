package trello.Entities;

import java.util.ArrayList;
import java.util.List;

public class DashBoard {
    List<Board> boards = new ArrayList<>();

    @Override
    public String toString() {
        return boards.toString();
    }

    public List<Board> getBoards() {
        return boards;
    }
}
