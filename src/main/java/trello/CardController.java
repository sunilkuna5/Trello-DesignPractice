package trello;

import trello.Entities.Card;
import trello.Entities.TrelloList;
import trello.Entities.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CardController {

    private final UserController userController;
    private final TrelloListController trelloListController;
    private final Map<String,Card> cardMap;
    private final Map<String,String> cardIDToListIDMap;

    public CardController(TrelloListController trelloListController, UserController userController) {
        this.trelloListController = trelloListController;
        this.userController = userController;
        cardMap = new HashMap<>();
        cardIDToListIDMap = new HashMap<>();
    }

    public String createCard(String listId, String name){
        TrelloList trelloList = trelloListController.getList(listId);
        if(trelloList != null) {
            Card card = new Card(name);
            trelloList.getCards().add(card);
            cardMap.put(card.getId(),card);
            cardIDToListIDMap.put(card.getId(),trelloList.getId());
            return card.getId();
        }
        return "";
    }

    public Card getCard(String id){
        return cardMap.get(id);
    }

    public void setName(String id, String name){
        if(cardMap.containsKey(id))
            cardMap.get(id).setName(name);
    }

    public void setDescription(String id, String name){
        if(cardMap.containsKey(id))
            cardMap.get(id).setDescription(name);
    }

    public void assignUser(String id, String userId){
        if(cardMap.containsKey(id)) {
            User user = userController.getBoardByUserID(userId);
            cardMap.get(id).setUser(user);
        }
    }

    public void moveCard(String id, String toListID){
        if(cardMap.containsKey(id)) {
            Card card = cardMap.get(id);
            String fromListID = cardIDToListIDMap.get(id);
            trelloListController.getList(fromListID).getCards().remove(card);
            trelloListController.getList(toListID).getCards().add(card);
            cardIDToListIDMap.put(id,toListID);
        }
    }

    public void deleteCard(String id) {
        if(cardIDToListIDMap.containsKey(id)) {
            String listID = cardIDToListIDMap.get(id);
            Iterator<Card> iterator = trelloListController.getList(listID).getCards().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId().equals(id))
                    iterator.remove();
            }
        }
        if(cardMap.containsKey(id))
            cardMap.remove(id);
        if(cardIDToListIDMap.containsKey(id))
            cardIDToListIDMap.remove(id);
    }
}
