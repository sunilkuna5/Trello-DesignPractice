package CommandLineInterface;

import trello.BoardController;
import trello.Entities.Board;
import trello.Entities.PrivacyType;
import trello.Entities.util.StringUtils;

public class BoardCommandParser {

    BoardController boardController;
    String createBoardTemplate = "Created board : %s";
    String boardNotFoundTemplate = "Board %s does not exist";

    public BoardCommandParser(BoardController boardController) {
        this.boardController = boardController;
    }

    public String parse(String command) {
        String[] commandParams = command.split(" ");
        if(command.equals("SHOW")){
            return boardController.getBoards().toString();
        } else if(commandParams[0].equals("SHOW")){
            Board board = boardController.getBoard(commandParams[2]);
            if(board!=null)
                return board.toString();
            return String.format(boardNotFoundTemplate,commandParams[2]);
        } else if (commandParams[1].equals("CREATE")){
            String name = command.substring(StringUtils.indexOf(command," ",2)+1);
            String id = boardController.addBoard(name);
            return String.format(createBoardTemplate,id);
        } else if (commandParams[1].equals("DELETE")){
            boardController.deleteBoard(commandParams[2]);
        } else if(commandParams[2].equals("name")){
            String name = command.substring(StringUtils.indexOf(command," ",3)+1);
            boardController.setName(commandParams[1],name);
        } else if(commandParams[2].equals("privacy")){
            boardController.setPrivacy(commandParams[1], PrivacyType.valueOf(commandParams[3]));
        } else if(commandParams[2].equals("ADD_MEMBER")){
            boardController.addMember(commandParams[1], commandParams[3]);
        } else if(commandParams[2].equals("REMOVE_MEMBER")){
            boardController.removeMember(commandParams[1], commandParams[3]);
        }
        return "";
    }

}
