package CommandLineInterface;

import trello.Entities.util.StringUtils;
import trello.TrelloListController;

public class ListCommandParser {

    TrelloListController trelloListController;
    String createBoardTemplate = "Created List : %s";


    public ListCommandParser(TrelloListController trelloListController) {
        this.trelloListController = trelloListController;
    }

    public String parse(String command) {
        String[] commandParams = command.split(" ");
        if(commandParams[0].equals("SHOW")){
            return trelloListController.getList(commandParams[2]).toString();
        } else if (commandParams[1].equals("CREATE")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            String id = trelloListController.createList(commandParams[2],name);
            return String.format(createBoardTemplate,id);
        } else if (commandParams[1].equals("DELETE")){
            trelloListController.deleteList(commandParams[2]);
        } else if(commandParams[2].equals("name")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            trelloListController.setName(commandParams[1],name);
        }
        return "";
    }

}
