package CommandLineInterface;

import trello.BoardController;
import trello.CardController;
import trello.TrelloListController;
import trello.UserController;

public class CommandLineAdapter {

    UserController userController = new UserController();
    BoardController boardController = new BoardController(userController);
    TrelloListController trelloListController = new TrelloListController(boardController);
    CardController cardController = new CardController(trelloListController, userController);

    BoardCommandParser boardCommandParser = new BoardCommandParser(boardController);
    ListCommandParser listCommandParser = new ListCommandParser(trelloListController);
    CardCommandParser cardCommandParser = new CardCommandParser(cardController);

    public CommandLineAdapter() {
        userController.addUser("Sagar Jain","sagar@workat.tech");
        userController.addUser("Sunil Reddy","sunil@workat.tech");
        userController.addUser("Gaurav Chandak","gaurav@workat.tech");
    }

    public String parse(String command){
        if(command.startsWith("BOARD"))
            return boardCommandParser.parse(command);
        else if(command.startsWith("LIST"))
            return listCommandParser.parse(command);
        else if(command.startsWith("CARD"))
            return cardCommandParser.parse(command);
        else if(command.startsWith("SHOW")) {
            if (command.length() == 4) {
                return boardCommandParser.parse(command);
            } else {
                String subCommand = command.substring(5);
                if (subCommand.startsWith("BOARD"))
                    return boardCommandParser.parse(command);
                if (subCommand.startsWith("LIST"))
                    return listCommandParser.parse(command);
                if (subCommand.startsWith("SHOW"))
                    return cardCommandParser.parse(command);
            }
        }
        return "";
    }
}
