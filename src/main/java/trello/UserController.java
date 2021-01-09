package trello;

import trello.Entities.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserController {

    private Map<String, User> userMap = new HashMap<>();
    private Map<String, User> userEmailMap = new HashMap<>();

    public String addUser(String name, String email) {
        User user = new User(name,email);
        userMap.put(user.getId(),user);
        userEmailMap.put(user.getEmail(),user);
        return user.getId();
    }

    public User getBoardByUserID(String userId){
        return userMap.get(userId);
    }

    public User getBoardByUserEmail(String email){
        return userEmailMap.get(email);
    }
}
