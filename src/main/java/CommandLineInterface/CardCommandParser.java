package CommandLineInterface;

import trello.CardController;
import trello.Entities.util.StringUtils;

public class CardCommandParser {

    CardController cardController;
    String createBoardTemplate = "Created card : %s";


    public CardCommandParser(CardController cardController) {
        this.cardController = cardController;
    }

    public String parse(String command) {
        String[] commandParams = command.split(" ");
        if(commandParams[0].equals("SHOW")){
            return cardController.getCard(commandParams[2]).toString();
        } else if (commandParams[1].equals("CREATE")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            String id = cardController.createCard(commandParams[2],name);
            return String.format(createBoardTemplate,id);
        } else if (commandParams[1].equals("DELETE")){
            cardController.deleteCard(commandParams[2]);
        } else if(commandParams[2].equals("name")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            cardController.setName(commandParams[1],commandParams[3]);
        } else if(commandParams[2].equals("description")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            cardController.setDescription(commandParams[1],commandParams[3]);
        } else if(commandParams[2].equals("ASSIGN")){
            cardController.assignUser(commandParams[1],commandParams[3]);
        } else if(commandParams[2].equals("UNASSIGN")){
            cardController.assignUser(commandParams[1],"");
        } else if(commandParams[2].equals("MOVE")){
            cardController.moveCard(commandParams[1],commandParams[3]);
        }
        return "";
    }

}
