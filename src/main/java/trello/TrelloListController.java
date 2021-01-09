package trello;

import trello.Entities.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TrelloListController {

    private BoardController boardController;
    private Map<String,TrelloList> trelloListMap;
    private Map<String,String> listIDToBoardIDMap;

    public TrelloListController(BoardController boardController) {
        this.boardController = boardController;
        trelloListMap = new HashMap<>();
        listIDToBoardIDMap = new HashMap<>();
    }

    public String createList(String boardId, String name){
        Board board = boardController.getBoard(boardId);
        if(board != null) {
            TrelloList trelloList = new TrelloList(name);
            board.getLists().add(trelloList);
            trelloListMap.put(trelloList.getId(),trelloList);
            listIDToBoardIDMap.put(trelloList.getId(),boardId);
            return trelloList.getId();
        }
        return "";
    }

    public TrelloList getList(String id){
        return trelloListMap.get(id);
    }

    public void setName(String id, String name){
        if(trelloListMap.containsKey(id))
            trelloListMap.get(id).setName(name);
    }

    public void deleteList(String id) {
        if(listIDToBoardIDMap.containsKey(id)) {
            String boardId = listIDToBoardIDMap.get(id);
            Iterator<TrelloList> iterator = boardController.getBoard(boardId).getLists().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId().equals(id))
                    iterator.remove();
            }
        }
        if(trelloListMap.containsKey(id))
            trelloListMap.remove(id);
        if(listIDToBoardIDMap.containsKey(id))
            listIDToBoardIDMap.remove(id);
    }
}
