package personal.controllers;

import personal.model.Repository;
import personal.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final Repository repository;


    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) throws Exception {
        repository.CreateUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        User user = userSearch(userId, users);
        return user;
    }

    private static User userSearch(String userId, List<User> users) throws Exception {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }

    public List<User> readAllUsers() {
        return repository.getAllUsers();
    }

    public void updateUser(String userId, User newUser) throws Exception {

        List<User> users = repository.getAllUsers();
        User user = userSearch(userId, users);
        user.setHeader(newUser.getHeader());
        user.setText(newUser.getText());
        user.setNote(newUser.getNote());
        repository.saveUsers(users);
    }

    public void deleteUser(String readId) {
        List<User> users = repository.getAllUsers();
        List<User> newUsers = new ArrayList<>();
        for (User user : users) {
            String tempId = user.getId();
            if (!tempId.equals(readId))
                newUsers.add(user);
        }
        repository.saveUsers(newUsers);
    }
}
