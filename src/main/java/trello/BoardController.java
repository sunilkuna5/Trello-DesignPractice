package trello;

import trello.Entities.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BoardController {

    private DashBoard dashBoard = new DashBoard();
    private Map<String, Board> map = new HashMap<>();
    private UserController userController = new UserController();

    public BoardController(UserController userController) {
        this.userController = userController;
    }

    public String addBoard(String name) {
        Board board = new Board(name);
        map.put(board.getId(),board);
        dashBoard.getBoards().add(board);
        return board.getId();
    }

    public Board getBoard(String boardId){
        return map.get(boardId);
    }

    public void deleteBoard(String boardId) {
        if(map.containsKey(boardId)) {
            Board board = map.remove(boardId);
            dashBoard.getBoards().remove(board);
        }
    }

    public void setName(String id, String name) {
        if(map.containsKey(id))
            map.get(id).setName(name);
    }

    public void setPrivacy(String id, PrivacyType privacyType) {
        if(map.containsKey(id))
            map.get(id).setPrivacyType(privacyType);
    }

    public void addMember(String id, String userId) {
        if(map.containsKey(id))
            map.get(id).getMembers().add(userController.getBoardByUserID(userId));
    }

    public void removeMember(String id, String userId) {
        if(map.containsKey(id)){
            Board board = map.get(id);
            User user = userController.getBoardByUserID(userId);
            for(TrelloList trelloList : board.getLists()){
                for(Card card : trelloList.getCards()){
                    if(card.getUser() == user)
                        card.setUser(null);
                }
            }
            Iterator<User> userIterator = board.getMembers().iterator();
            while (userIterator.hasNext()){
                User iteratedUser = userIterator.next();
                if(user == iteratedUser)
                    userIterator.remove();
            }
        }
    }

    public List<Board> getBoards() {
        return dashBoard.getBoards();
    }
}
